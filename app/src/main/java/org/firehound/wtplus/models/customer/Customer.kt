package org.firehound.wtplus.models.customer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

class Customer {

    @SerializedName("customer_name")
    @Expose
    var customerName: String? = null
    @SerializedName("customer_uid")
    @Expose
    var customerUid: String? = null
    @SerializedName("customer_phone_number")
    @Expose
    var customerPhoneNumber: CustomerPhoneNumber? = null
    @SerializedName("customer_email")
    @Expose
    var customerEmail: CustomerEmail? = null
    @SerializedName("password")
    @Expose
    var password: String? = null
    @SerializedName("customer_address")
    @Expose
    var customerAddress: String? = null
    @SerializedName("customer_address_pin")
    @Expose
    var customerAddressPin: Int? = null
    @SerializedName("customer_cart")
    @Expose
    var customerCart: CustomerCart? = null

    override fun toString(): String {
        return ToStringBuilder(this).append("customerName", customerName)
            .append("customerUid", customerUid).append("customerPhoneNumber", customerPhoneNumber)
            .append("customerEmail", customerEmail).append("password", password)
            .append("customerAddress", customerAddress)
            .append("customerAddressPin", customerAddressPin).append("customerCart", customerCart)
            .toString()
    }

}