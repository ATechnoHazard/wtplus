package org.firehound.wtplus.models.reservation

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder
import org.firehound.wtplus.models.customer.CustomerCart

class Reservation {

    @SerializedName("customer")
    @Expose
    var customer: String? = null
    @SerializedName("customer_uid")
    @Expose
    var customerUid: String? = null
    @SerializedName("customer_name")
    @Expose
    var customerName: String? = null
    @SerializedName("customer_email")
    @Expose
    var customerEmail: String? = null
    @SerializedName("customer_mobile")
    @Expose
    var customerMobile: String? = null
    @SerializedName("total")
    @Expose
    var total: Int? = null
    @SerializedName("discount")
    @Expose
    var discount: Int? = null
    @SerializedName("customer_cart")
    @Expose
    var customerCart: CustomerCart? = null
    @SerializedName("pickup_location")
    @Expose
    var pickupLocation: PickupLocation? = null
    @SerializedName("reservation_slot")
    @Expose
    var reservationSlot: String? = null
    @SerializedName("is_vegan")
    @Expose
    var isVegan: Boolean? = null
    @SerializedName("is_wt_member")
    @Expose
    var isWtMember: Boolean? = null

    override fun toString(): String {
        return ToStringBuilder(this).append("customer", customer).append("customerUid", customerUid)
            .append("customerName", customerName).append("customerEmail", customerEmail)
            .append("customerMobile", customerMobile).append("total", total)
            .append("discount", discount).append("customerCart", customerCart)
            .append("pickupLocation", pickupLocation).append("reservationSlot", reservationSlot)
            .append("isVegan", isVegan).append("isWtMember", isWtMember).toString()
    }
}