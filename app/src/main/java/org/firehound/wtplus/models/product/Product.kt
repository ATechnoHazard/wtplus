package org.firehound.wtplus.models.product

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

class Product {

    @SerializedName("product_name")
    @Expose
    var productName: String? = null
    @SerializedName("product_description")
    @Expose
    var productDescription: String? = null
    @SerializedName("product_short_name")
    @Expose
    var productShortName: String? = null
    @SerializedName("product_brand_name")
    @Expose
    var productBrandName: String? = null
    @SerializedName("product_id")
    @Expose
    var productId: String? = null
    @SerializedName("product_category")
    @Expose
    var productCategory: ProductCategory? = null
    @SerializedName("product_colours")
    @Expose
    var productColours: List<ProductColour>? = null
    @SerializedName("product_styling_note")
    @Expose
    var productStylingNote: String? = null
    @SerializedName("product_reservation_period")
    @Expose
    var productReservationPeriod: Int? = null
    @SerializedName("product_images")
    @Expose
    var productImages: List<ProductImage>? = null
    @SerializedName("product_price")
    @Expose
    var productPrice: Float? = null
    @SerializedName("product_volumes")
    @Expose
    var productVolumes: List<ProductVolume>? = null

    var savedSize: String? = null

    override fun toString(): String {
        return ToStringBuilder(this).append("productName", productName)
            .append("productDescription", productDescription)
            .append("productShortName", productShortName)
            .append("productBrandName", productBrandName).append("productId", productId)
            .append("productCategory", productCategory).append("productColours", productColours)
            .append("productStylingNote", productStylingNote)
            .append("productReservationPeriod", productReservationPeriod)
            .append("productPrice", productPrice)
            .append("productVolumes", productVolumes)
            .append("productImages", productImages).toString()
    }
}