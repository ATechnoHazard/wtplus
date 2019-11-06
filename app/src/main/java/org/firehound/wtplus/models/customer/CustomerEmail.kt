package org.firehound.wtplus.models.customer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

class CustomerEmail {

    @SerializedName("email")
    @Expose
    var email: String? = null

    override fun toString(): String {
        return ToStringBuilder(this).append("email", email).toString()
    }

}