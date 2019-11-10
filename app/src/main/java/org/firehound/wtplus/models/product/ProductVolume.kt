package org.firehound.wtplus.models.product

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

class ProductVolume {

    @SerializedName("product_size")
    @Expose
    var productSize: String? = null
    @SerializedName("intial_product_quantity")
    @Expose
    var intialProductQuantity: Int? = null
    @SerializedName("reserved_quantity")
    @Expose
    var reservedQuantity: Int? = null
    @SerializedName("final_product_quantity")
    @Expose
    var finalProductQuantity: Int? = null

    override fun toString(): String {
        return ToStringBuilder(this).append("productSize", productSize)
            .append("intialProductQuantity", intialProductQuantity)
            .append("reservedQuantity", reservedQuantity)
            .append("finalProductQuantity", finalProductQuantity).toString()
    }
}