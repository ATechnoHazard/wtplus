package org.firehound.wtplus.models.customer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder
import org.firehound.wtplus.models.Product

class CustomerCart {

    @SerializedName("products")
    @Expose
    var products: List<Product>? = null

    override fun toString(): String {
        return ToStringBuilder(this).append("products", products).toString()
    }
}
