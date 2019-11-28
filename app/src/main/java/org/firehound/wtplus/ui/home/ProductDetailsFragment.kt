package org.firehound.wtplus.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import kotlinx.android.synthetic.main.cart_menu_item.*
import kotlinx.android.synthetic.main.cart_menu_item.view.*
import kotlinx.android.synthetic.main.fragment_product_details.*
import org.firehound.wtplus.R
import org.firehound.wtplus.adapters.SliderAdapter
import org.firehound.wtplus.models.product.Product
import org.firehound.wtplus.utils.hide
import org.firehound.wtplus.utils.show
import org.firehound.wtplus.utils.toast
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ProductDetailsFragment : Fragment() {

    private val viewModel by sharedViewModel<ProductViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_product_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product = viewModel.selectedProduct

        image_slider.sliderAdapter = SliderAdapter(requireContext(), product)

        details_brand.text = product.productBrandName
        details_name.text = product.productName
        details_price.text = "SGD " + product.productPrice
        details_desc.text = product.productDescription

        val items = product.productVolumes?.map {
            it.productSize.toString()
        }

        add_cart_fab.setOnClickListener {
            MaterialDialog(requireContext())
                .title(R.string.size_select_dialog_text)
                .show {
                    listItemsSingleChoice(items = items) { dialog, _, text ->
                        val insertItem = Product()
                        insertItem.productId = product.productId
                        insertItem.savedSize = text.toString()
                        if (viewModel.addToCart(insertItem)) {
                            toast("Item added to cart.")
                            dialog.dismiss()
                        } else {
                            toast("Only one of each size allowed!")
                            dialog.dismiss()
                        }
                    }
                }
        }
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
