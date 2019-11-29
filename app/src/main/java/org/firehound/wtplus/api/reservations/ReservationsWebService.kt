package org.firehound.wtplus.api.reservations

import org.firehound.wtplus.models.reservation.CreateReservationResponse
import org.firehound.wtplus.models.reservation.Reservation
import retrofit2.Response
import retrofit2.http.*

interface ReservationsWebService {
    @GET("reservations")
    suspend fun getAllReservations(): Response<List<Reservation>>

    @GET("reservations/{resId}")
    suspend fun getReservationById(@Path("resId") resId: String): Response<Reservation>

    @POST("reservations/create")
    suspend fun createReservation(@Body reservation: Reservation):
            Response<String>

    @PUT("reservations/{resId}/update")
    suspend fun updateReservation(
        @Path("resId") resId: String,
        @Body reservation: Reservation
    ): Response<String>

    @DELETE("reservations/{resId}/delete")
    suspend fun deleteReservation(@Path("resId") resId: String): Response<String>
}