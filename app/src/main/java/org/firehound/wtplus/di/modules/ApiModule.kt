package org.firehound.wtplus.di.modules

import org.firehound.wtplus.api.customers.CustomerWebClient
import org.firehound.wtplus.api.customers.CustomerWebService
import org.firehound.wtplus.api.getOkHttpClient
import org.firehound.wtplus.api.product.ProductWebClient
import org.firehound.wtplus.api.product.ProductWebService
import org.firehound.wtplus.api.reservations.ReservationsWebClient
import org.firehound.wtplus.api.reservations.ReservationsWebService
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val BASE_URL = "http://ec2-3-87-126-246.compute-1.amazonaws.com:3000/"

val apiModule = module {
    factory { getOkHttpClient(androidContext()) } // provides okhttp client

    single(named("CUSTOMER_RETROFIT")) {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single(named("PRODUCT_RETROFIT")) {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single(named("RESERVATION_RETROFIT")) {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    factory { get<Retrofit>(named("CUSTOMER_RETROFIT")).create(CustomerWebService::class.java) } // provides a named instance for Customer
    factory { get<Retrofit>(named("PRODUCT_RETROFIT")).create(ProductWebService::class.java) } // provides a named instance for Product
    factory { get<Retrofit>(named("RESERVATION_RETROFIT")).create(ReservationsWebService::class.java) } // provides a named instance for Reservation

    factory { CustomerWebClient(get()) } // provides our final web client for customer
    factory { ProductWebClient(get()) } // provides our final web client for products
    factory { ReservationsWebClient(get()) } // provides our final web client for reservations
}