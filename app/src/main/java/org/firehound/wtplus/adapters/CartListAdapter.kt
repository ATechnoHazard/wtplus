package org.firehound.wtplus.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.cart_item.*
import org.firehound.wtplus.R
import org.firehound.wtplus.models.product.Product
import org.firehound.wtplus.utils.round
import java.net.URL

class CartListAdapter(private val context: Context) :
    RecyclerView.Adapter<CartListAdapter.CartViewHolder>() {

    private var cartItems: List<Product> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CartViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.cart_item,
                parent,
                false
            )
        )

    override fun getItemCount() = cartItems.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val product = cartItems[position]

        val url = URL(product.productImages?.get(0)?.imageUrl)
        val newUrl = URL("http://ec2-3-87-126-246.compute-1.amazonaws.com" + url.path)

        Glide.with(context).load(newUrl.toString())
            .into(holder.cartitem_image)

        holder.cartitem_brand.text = product.productBrandName
        holder.cartitem_name.text = product.productName
        holder.cartitem_size.text = "Size " + product.savedSize
        holder.cartitem_price.text = "$ ${product.productPrice?.round(2).toString()}"
    }

    class CartViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer

    fun updateData(newData: List<Product>) {
        cartItems = newData
        notifyDataSetChanged()
    }
}