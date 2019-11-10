package org.firehound.wtplus.models.reservation

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

class CreateReservationResponse {

    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("reservation")
    @Expose
    var reservation: Reservation? = null
    @SerializedName("out_of_stock")
    @Expose
    var outOfStock: List<Any>? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param outOfStock
     * @param reservation
     * @param message
     * @param status
     */
    constructor(
        status: String,
        message: String,
        reservation: Reservation,
        outOfStock: List<Any>
    ) : super() {
        this.status = status
        this.message = message
        this.reservation = reservation
        this.outOfStock = outOfStock
    }

    fun withStatus(status: String): CreateReservationResponse {
        this.status = status
        return this
    }

    fun withMessage(message: String): CreateReservationResponse {
        this.message = message
        return this
    }

    fun withReservation(reservation: Reservation): CreateReservationResponse {
        this.reservation = reservation
        return this
    }

    fun withOutOfStock(outOfStock: List<Any>): CreateReservationResponse {
        this.outOfStock = outOfStock
        return this
    }

    override fun toString(): String {
        return ToStringBuilder(this).append("status", status).append("message", message)
            .append("reservation", reservation).append("outOfStock", outOfStock).toString()
    }
}