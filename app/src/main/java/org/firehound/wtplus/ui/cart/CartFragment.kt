package org.firehound.wtplus.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cart.*
import org.firehound.wtplus.R
import org.firehound.wtplus.adapters.CartListAdapter
import org.firehound.wtplus.ui.home.ProductViewModel
import org.firehound.wtplus.utils.round
import org.koin.android.viewmodel.ext.android.sharedViewModel

class CartFragment : Fragment() {

    private val viewModel by sharedViewModel<ProductViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cartAdapter = CartListAdapter(requireContext())
        val manager = LinearLayoutManager(requireContext())
        cart_recyclerview.apply {
            adapter = cartAdapter
            layoutManager = manager
        }

        viewModel.cartLiveData.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                cartAdapter.updateData(it)
                var total = 0.0f
                it.forEach {product ->
                    total += product.productPrice!!
                }
                cart_total.text = "$ ${total.round(2)}"
            }
        })

    }

}
