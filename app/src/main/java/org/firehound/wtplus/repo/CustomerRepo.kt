package org.firehound.wtplus.repo

import org.firehound.wtplus.api.customers.CustomerWebClient
import org.firehound.wtplus.models.customer.Customer

class CustomerRepo(
    private val webClient: CustomerWebClient
) : BaseRepo() {
    fun getAllCustomers() = makeRequest {
        webClient.getAllCustomers()
    }

    fun getCustomerById(customerId: String) = makeRequest {
        webClient.getCustomerById(customerId)
    }

    fun createCustomer(customer: Customer) = makeRequest {
        webClient.createCustomer(customer)
    }

    fun updateCustomer(customerId: String, customer: Customer) = makeRequest {
        webClient.updateCustomer(customerId, customer)
    }

    fun deleteCustomer(customerId: String) = makeRequest {
        webClient.deleteCustomer(customerId)
    }

    fun getCustomerByEmail(email: String) = makeRequest {
        webClient.getCustomerByEmail(email)
    }

    fun getCustomerByPhone(phone: String) = makeRequest {
        webClient.getCustomerByPhone(phone)
    }

    fun doesEmailExist(email: String) = makeRequest {
        webClient.doesEmailExist(email)
    }

    fun doesPhoneExist(phone: String) = makeRequest {
        webClient.doesPhoneExist(phone)
    }
}