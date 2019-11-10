package org.firehound.wtplus.api.customers

import org.firehound.wtplus.models.customer.Customer
import retrofit2.Response
import retrofit2.http.*

interface CustomerWebService {
    @GET("customers")
    suspend fun getAllCustomers(): Response<List<Customer>>

    @GET("customers/{customerId}")
    suspend fun getCustomerById(@Path("customerId") customerId: String): Response<Customer>

    @POST("customers/create")
    suspend fun createCustomer(@Body customer: Customer): Response<String>

    @PUT("customers/{customerId}/update")
    suspend fun updateCustomer(
        @Path("customerId") customerId: String,
        @Body customer: Customer
    ): Response<String>

    @DELETE("customers/{customerId}/delete")
    suspend fun deleteCustomer(@Path("customerId") customerId: String): Response<String>

    @GET("customers/{email}/email")
    suspend fun getCustomerByEmail(@Path("email") email: String): Response<Customer>

    @GET("customers/{phone}/phone")
    suspend fun getCustomerByPhone(@Path("phone") phone: String): Response<Customer>

    @GET("customers/{email}/emailvalidate")
    suspend fun doesEmailExist(@Path("email") email: String): Response<String>

    @GET("customers/{phone}/phonevalidate")
    suspend fun doesPhoneExist(@Path("phone") phone: String): Response<String>
}