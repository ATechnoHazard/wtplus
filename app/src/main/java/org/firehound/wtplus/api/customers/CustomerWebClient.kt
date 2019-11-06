package org.firehound.wtplus.api.customers

import org.firehound.wtplus.api.BaseApiClient
import org.firehound.wtplus.models.customer.Customer

class CustomerWebClient(private val webService: CustomerWebService): BaseApiClient() {
    suspend fun getAllCustomers() = getResult {
        webService.getAllCustomers()
    }

    suspend fun getCustomerById(customerId: String) = getResult {
        webService.getCustomerById(customerId)
    }

    suspend fun createCustomer(customer: Customer) = getResult {
        webService.createCustomer(customer)
    }

    suspend fun updateCustomer(customerId: String, customer: Customer) = getResult {
        webService.updateCustomer(customerId, customer)
    }

    suspend fun deleteCustomer(customerId: String) = getResult {
        webService.deleteCustomer(customerId)
    }

    suspend fun getCustomerByEmail(email: String) = getResult {
        webService.getCustomerByEmail(email)
    }

    suspend fun getCustomerByPhone(phone: String) = getResult {
        webService.getCustomerByPhone(phone)
    }

    suspend fun doesEmailExist(email: String) = getResult {
        webService.doesEmailExist(email)
    }

    suspend fun doesPhoneExist(phone: String) = getResult {
        webService.doesPhoneExist(phone)
    }
}