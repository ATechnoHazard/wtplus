package org.firehound.wtplus.models.product

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

class ProductImage {

    @SerializedName("image_name")
    @Expose
    var imageName: String? = null
    @SerializedName("image_url")
    @Expose
    var imageUrl: String? = null
    @SerializedName("image_short_name")
    @Expose
    var imageShortName: String? = null
    @SerializedName("image_description")
    @Expose
    var imageDescription: String? = null

    override fun toString(): String {
        return ToStringBuilder(this).append("imageName", imageName).append("imageUrl", imageUrl)
            .append("imageShortName", imageShortName).append("imageDescription", imageDescription)
            .toString()
    }
}