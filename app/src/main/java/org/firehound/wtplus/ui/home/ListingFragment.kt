package org.firehound.wtplus.ui.home

import GridItemDecoration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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

                }

                Result.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) {
                        adapter.updateData(it.data)
                        product_recyclerview.show()
                    }
                }

                Result.Status.ERROR -> {
                    toast(it.message!!)
                    product_recyclerview.hide()
                }
            }
        })
    }
}
