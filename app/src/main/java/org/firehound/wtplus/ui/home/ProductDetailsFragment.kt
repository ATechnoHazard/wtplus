package org.firehound.wtplus.ui.home

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.listItemsSingleChoice
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            image_slider.transitionName = viewModel.selectedProduct.productId
        }

        details_brand.text = product.productBrandName
        details_name.text = product.productName
        details_price.text = "$ " + product.productPrice
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

                        insertItem.apply {
                            productId = product.productId
                            savedSize = text.toString()
                            productName = product.productName
                            productPrice = product.productPrice
                            productBrandName = product.productBrandName
                            productImages = product.productImages
                        }

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
        startPostponedEnterTransition()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        val actionView = menu.findItem(R.id.action_cart).actionView
        viewModel.cartLiveData.observe(viewLifecycleOwner, Observer {
            when (it.size) {
                0 -> {
                    actionView.cart_badge.hide()
                }
                else -> {
                    actionView.cart_badge.show()
                    actionView.cart_badge.text = it.size.toString()
                }
            }
        })
        actionView.setOnClickListener {
            if (viewModel.cartLiveData.value.isNullOrEmpty()) {
                toast("Your cart is empty!")
            } else {
                val action =
                    ProductDetailsFragmentDirections.actionProductDetailsFragmentToCartFragment()
                findNavController().navigate(action)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition =
                TransitionInflater.from(context)
                    .inflateTransition(android.R.transition.slide_left)
            postponeEnterTransition()
        }
    }

}
