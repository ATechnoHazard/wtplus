package org.firehound.wtplus.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

class Product {

    @SerializedName("product")
    @Expose
    var product: String? = null
    @SerializedName("product_name")
    @Expose
    var productName: String? = null
    @SerializedName("product_sku")
    @Expose
    var productSku: String? = null
    @SerializedName("product_id")
    @Expose
    var productId: String? = null
    @SerializedName("product_colour")
    @Expose
    var productColour: String? = null
    @SerializedName("product_size")
    @Expose
    var productSize: String? = null
    @SerializedName("product_price")
    @Expose
    var productPrice: String? = null
    @SerializedName("product_brand_name")
    @Expose
    var productBrandName: String? = null
    @SerializedName("product_quantity")
    @Expose
    var productQuantity: String? = null

    override fun toString(): String {
        return ToStringBuilder(this).append("product", product).append("productName", productName)
            .append("productSku", productSku).append("productId", productId)
            .append("productColour", productColour).append("productSize", productSize)
            .append("productPrice", productPrice).append("productBrandName", productBrandName)
            .append("productQuantity", productQuantity).toString()
    }

}