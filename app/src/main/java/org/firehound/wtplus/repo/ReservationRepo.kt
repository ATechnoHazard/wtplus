package org.firehound.wtplus.repo

import org.firehound.wtplus.api.reservations.ReservationsWebClient
import org.firehound.wtplus.models.reservation.Reservation

class ReservationRepo(
    private val webClient: ReservationsWebClient
) : BaseRepo() {
    fun getAllReservations() = makeRequest {
        webClient.getAllReservations()
    }

    fun getReservationById(resId: String) = makeRequest {
        webClient.getReservationById(resId)
    }

    fun createReservation(reservation: Reservation) = makeRequest {
        webClient.createReservation(reservation)
    }

    fun updateReservation(resId: String, reservation: Reservation) = makeRequest {
        webClient.updateReservation(resId, reservation)
    }

    fun deleteReservation(resId: String) = makeRequest {
        webClient.deleteReservation(resId)
    }
}