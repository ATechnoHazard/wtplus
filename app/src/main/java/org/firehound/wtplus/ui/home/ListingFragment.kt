package org.firehound.wtplus.ui.home

import GridItemDecoration
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.cart_menu_item.*
import kotlinx.android.synthetic.main.cart_menu_item.view.*
import kotlinx.android.synthetic.main.fragment_listing.*

import org.firehound.wtplus.R
import org.firehound.wtplus.adapters.ProductListAdapter
import org.firehound.wtplus.models.Result
import org.firehound.wtplus.utils.hide
import org.firehound.wtplus.utils.show
import org.firehound.wtplus.utils.toast
import org.koin.android.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass.
 */
class ListingFragment : Fragment() {

    private val viewModel by sharedViewModel<ProductViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ProductListAdapter(requireContext()) {
            viewModel.selectedProduct = it
            val action = ListingFragmentDirections.actionListingFragmentToProductDetailsFragment()
            findNavController().navigate(action)
        }

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        product_recyclerview.addItemDecoration(GridItemDecoration(16))
        product_recyclerview.adapter = adapter
        product_recyclerview.layoutManager = layoutManager

        viewModel.getAllProducts().observe(viewLifecycleOwner, Observer {
            when(it.status) {
                Result.Status.LOADING -> {
                    product_recyclerview.hide()
                    spinkit.show()
                }

                Result.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) {
                        adapter.updateData(it.data)
                        product_recyclerview.show()
                        spinkit.hide()
                    }
                }

                Result.Status.ERROR -> {
                    toast(it.message!!)
                    product_recyclerview.hide()
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        viewModel.cartLiveData.observe(viewLifecycleOwner, Observer {
            when (it.size) {
                0 -> {
                    menu.findItem(R.id.action_cart).actionView.cart_badge.hide()
                }
                else -> {
                    menu.findItem(R.id.action_cart).actionView.cart_badge.show()
                    menu.findItem(R.id.action_cart).actionView.cart_badge.text = it.size.toString()
                }
            }
        })
    }
}
