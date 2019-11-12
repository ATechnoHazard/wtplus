package org.firehound.wtplus.api.reservations

import org.firehound.wtplus.api.BaseApiClient
import org.firehound.wtplus.models.reservation.Reservation

class ReservationsWebClient(private val webService: ReservationsWebService): BaseApiClient() {
    suspend fun getAllReservations() = getResult {
        webService.getAllReservations()
    }

    suspend fun getReservationById(resId: String) = getResult {
        webService.getReservationById(resId)
    }

    suspend fun createReservation(reservation: Reservation) = getResult {
        webService.createReservation(reservation)
    }

    suspend fun updateReservation(resId: String, reservation: Reservation) = getResult {
        webService.updateReservation(resId, reservation)
    }

    suspend fun deleteReservation(resId: String) = getResult {
        webService.deleteReservation(resId)
    }
}