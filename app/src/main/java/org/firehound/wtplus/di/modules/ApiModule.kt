package org.firehound.wtplus.di.modules

import org.firehound.wtplus.api.customers.CustomerWebClient
import org.firehound.wtplus.api.customers.CustomerWebService
import org.firehound.wtplus.api.getOkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val BASE_URL = "http://ec2-3-87-126-246.compute-1.amazonaws.com:3000/"

val apiModule = module {
    factory { getOkHttpClient(androidContext()) }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(get())
            .build()
    }

    factory { get<Retrofit>().create(CustomerWebService::class.java) }
    factory { CustomerWebClient(get()) }
}