package org.firehound.wtplus.models.customer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

class CustomerPhoneNumber {

    @SerializedName("phone_code")
    @Expose
    var phoneCode: String? = null
    @SerializedName("phone_number")
    @Expose
    var phoneNumber: String? = null

    override fun toString(): String {
        return ToStringBuilder(this).append("phoneCode", phoneCode)
            .append("phoneNumber", phoneNumber).toString()
    }

}