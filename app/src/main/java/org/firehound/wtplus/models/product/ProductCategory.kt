package org.firehound.wtplus.models.product

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

class ProductCategory {

    @SerializedName("category_name")
    @Expose
    var categoryName: String? = null
    @SerializedName("category_description")
    @Expose
    var categoryDescription: String? = null
    @SerializedName("category_short_name")
    @Expose
    var categoryShortName: String? = null

    override fun toString(): String {
        return ToStringBuilder(this).append("categoryName", categoryName)
            .append("categoryDescription", categoryDescription)
            .append("categoryShortName", categoryShortName).toString()
    }
}