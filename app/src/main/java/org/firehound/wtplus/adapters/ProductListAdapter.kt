package org.firehound.wtplus.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.product_recyclerview_item.*
import org.firehound.wtplus.R
import org.firehound.wtplus.models.product.Product
import java.net.URL

class ProductListAdapter(private val context: Context, val listener: (Product) -> Unit) :
    RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    private var productList: List<Product> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.product_recyclerview_item,
                parent,
                false
            )
        )


    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.containerView.setOnClickListener {
            listener(product)
        }

        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 7f
        circularProgressDrawable.centerRadius = 40f
        circularProgressDrawable.start()
        val url = URL(product.productImages?.get(0)?.imageUrl)
        val newUrl = URL("http://ec2-3-87-126-246.compute-1.amazonaws.com" + url.path)

//        Log.d("adapter", newUrl.toString())
        Glide.with(context).load(newUrl.toString())
            .placeholder(circularProgressDrawable).into(holder.product_image)

        holder.product_brand.text = product.productBrandName
        holder.product_name.text = product.productName
        holder.product_price.text = "SGD " + product.productPrice.toString()
    }

    fun updateData(newData: List<Product>) {
        productList = newData
        notifyDataSetChanged()
    }

    class ProductViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer
}