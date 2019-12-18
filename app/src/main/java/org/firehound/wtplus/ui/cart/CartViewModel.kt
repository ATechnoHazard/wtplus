package org.firehound.wtplus.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.firehound.wtplus.models.reservation.Reservation
import org.firehound.wtplus.repo.ReservationRepo

class CartViewModel(private val repo: ReservationRepo): ViewModel() {
    fun createReservation(req: Reservation) = repo.createReservation(req)

    var isWtMember = MutableLiveData<Boolean>()
}