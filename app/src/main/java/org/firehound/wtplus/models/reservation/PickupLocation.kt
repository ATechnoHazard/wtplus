package org.firehound.wtplus.models.reservation

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

class PickupLocation {

    @SerializedName("location_name")
    @Expose
    var locationName: String? = null
    @SerializedName("location_Address")
    @Expose
    var locationAddress: String? = null

    override fun toString(): String {
        return ToStringBuilder(this).append("locationName", locationName)
            .append("locationAddress", locationAddress).toString()
    }
}