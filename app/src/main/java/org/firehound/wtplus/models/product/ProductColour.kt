package org.firehound.wtplus.models.product

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

class ProductColour {

    @SerializedName("product_colour")
    @Expose
    var productColour: String? = null
    @SerializedName("product_sku")
    @Expose
    var productSku: String? = null
    @SerializedName("product_price")
    @Expose
    var productPrice: Int? = null
    @SerializedName("product_volumes")
    @Expose
    var productVolumes: List<ProductVolume>? = null
    @SerializedName("product_images")
    @Expose
    var productImages: List<ProductImage>? = null
    @SerializedName("product_colour_price")
    @Expose
    var productColourPrice: Int? = null

    override fun toString(): String {
        return ToStringBuilder(this).append("productColour", productColour)
            .append("productSku", productSku).append("productPrice", productPrice)
            .append("productVolumes", productVolumes).append("productImages", productImages)
            .append("productColourPrice", productColourPrice).toString()
    }
}