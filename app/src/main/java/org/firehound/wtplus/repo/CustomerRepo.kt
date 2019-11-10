package org.firehound.wtplus.repo

import org.firehound.wtplus.api.customers.CustomerWebClient
import org.firehound.wtplus.models.customer.Customer

class CustomerRepo(
    private val webClient: CustomerWebClient
) : BaseRepo() {
    suspend fun getAllCustomers() = makeRequest {
        webClient.getAllCustomers()
    }

    suspend fun getCustomerById(customerId: String) = makeRequest {
        webClient.getCustomerById(customerId)
    }

    suspend fun createCustomer(customer: Customer) = makeRequest {
        webClient.createCustomer(customer)
    }

    suspend fun updateCustomer(customerId: String, customer: Customer) = makeRequest {
        webClient.updateCustomer(customerId, customer)
    }

    suspend fun deleteCustomer(customerId: String) = makeRequest {
        webClient.deleteCustomer(customerId)
    }

    suspend fun getCustomerByEmail(email: String) = makeRequest {
        webClient.getCustomerByEmail(email)
    }

    suspend fun getCustomerByPhone(phone: String) = makeRequest {
        webClient.getCustomerByPhone(phone)
    }

    suspend fun doesEmailExist(email: String) = makeRequest {
        webClient.doesEmailExist(email)
    }

    suspend fun doesPhoneExist(phone: String) = makeRequest {
        webClient.doesPhoneExist(phone)
    }
}