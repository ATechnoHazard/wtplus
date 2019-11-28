package org.firehound.wtplus.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.slider_item.*
import org.firehound.wtplus.R
import org.firehound.wtplus.models.product.Product
import java.net.URL


class SliderAdapter(private val context: Context, private val product: Product) :
    SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup) =
        SliderAdapterVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slider_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val url = URL(product.productImages?.get(position)?.imageUrl)
        val newUrl = URL("http://ec2-3-87-126-246.compute-1.amazonaws.com" + url.path)
        Glide.with(context).load(newUrl.toString()).into(viewHolder.image)
    }

    override fun getCount() = product.productImages?.size!!

    class SliderAdapterVH(override val containerView: View) :
        SliderViewAdapter.ViewHolder(containerView), LayoutContainer
}