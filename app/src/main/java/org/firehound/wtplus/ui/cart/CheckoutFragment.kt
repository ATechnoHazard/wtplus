package org.firehound.wtplus.ui.cart

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.afollestad.materialdialogs.MaterialDialog
import kotlinx.android.synthetic.main.fragment_checkout.*
import org.firehound.wtplus.R
import org.firehound.wtplus.models.Result
import org.firehound.wtplus.models.customer.CustomerCart
import org.firehound.wtplus.models.reservation.Reservation
import org.firehound.wtplus.ui.home.ProductViewModel
import org.firehound.wtplus.utils.isValidEmail
import org.firehound.wtplus.utils.isValidPhone
import org.firehound.wtplus.utils.toast
import org.koin.android.viewmodel.ext.android.sharedViewModel
import kotlin.random.Random

class CheckoutFragment : Fragment() {

    private val productViewModel by sharedViewModel<ProductViewModel>()
    private val cartViewModel by sharedViewModel<CartViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkout_radiogroup.setOnCheckedChangeListener { _, i ->
            cartViewModel.isWtMember.postValue(i == R.id.yes_radio)
        }

        cartViewModel.isWtMember.observe(viewLifecycleOwner, Observer {
            if (it) {
                val dupes = productViewModel.cartLiveData.value?.groupingBy { product -> product.productBrandName }
                    ?.eachCount()?.filter { entry ->
                        entry.value > 1
                    }
                if (!dupes.isNullOrEmpty()) {
                    MaterialDialog(requireContext()).show {
                        title(R.string.discount_applied_title)
                        message(R.string.discount_applied)
                    }
                }
            }
        })

        reservation_fab.setOnClickListener {
            val emailText = checkout_email_edittext.editText?.text.toString()
            val phNo = checkout_phone_edittext.editText?.text.toString()
            val name = checkout_name_edittext.editText?.text.toString()

            if (name.isBlank()) {
                checkout_name_edittext.error = "Entered name is invalid"
                return@setOnClickListener
            } else {
                checkout_name_edittext.error = null
            }

            if (!emailText.isValidEmail() || emailText.isBlank()) {
                checkout_email_edittext.error = "Entered email is invalid"
                return@setOnClickListener
            } else {
                checkout_email_edittext.error = null
            }

            if (!phNo.isValidPhone() || phNo.isBlank()) {
                checkout_phone_edittext.error = "Entered phone is invalid"
                return@setOnClickListener
            } else {
                checkout_phone_edittext.error = null
            }

            val req = Reservation()
            val cart = CustomerCart()
            cart.products = productViewModel.cartLiveData.value
            req.apply {
                customerCart = cart
                customerEmail = emailText
                customerMobile = phNo
                customerName = name
                isVegan = true
                isWtMember = cartViewModel.isWtMember.value
                reservationSlot = "11:00 AM - 12:00 Noon"
                customerUid = "WT+${Random.nextInt()}"
            }
            cartViewModel.createReservation(req).observe(viewLifecycleOwner, Observer {
                when (it.status) {
                    Result.Status.LOADING -> {

                    }

                    Result.Status.SUCCESS -> {
                        toast("Your reservation has been created")
                        Log.d("tag", it.data.toString())
                    }

                    else -> {
                        toast(it.message.toString())
                        Log.d("tag", it.message.toString())
                    }
                }
            })
        }

    }
}
