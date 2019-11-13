package org.firehound.wtplus.repo

import org.firehound.wtplus.api.reservations.ReservationsWebClient
import org.firehound.wtplus.models.reservation.Reservation

class ReservationRepo(
    private val webClient: ReservationsWebClient
): BaseRepo() {
    suspend fun getAllReservations() = makeRequest {
        webClient.getAllReservations()
    }

    suspend fun getReservationById(resId: String) = makeRequest {
        webClient.getReservationById(resId)
    }

    suspend fun createReservation(reservation: Reservation) = makeRequest {
        webClient.createReservation(reservation)
    }

    suspend fun updateReservation(resId: String, reservation: Reservation) = makeRequest {
        webClient.updateReservation(resId, reservation)
    }

    suspend fun deleteReservation(resId: String) = makeRequest {
        webClient.deleteReservation(resId)
    }
}