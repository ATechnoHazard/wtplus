package org.firehound.wtplus.api.product

import org.firehound.wtplus.api.BaseApiClient
import org.firehound.wtplus.models.product.Product

class ProductWebClient(private val webService: ProductWebService): BaseApiClient() {
    suspend fun getAllProducts() = getResult {
        webService.getAllProducts()
    }

    suspend fun getProductsById(productId: String) = getResult {
        webService.getProductById(productId)
    }

    suspend fun createProduct(product: Product) = getResult {
        webService.createProduct(product)
    }

    suspend fun updateProduct(productId: String, product: Product) = getResult {
        webService.updateProduct(productId, product)
    }

    suspend fun deleteProduct(productId: String) = getResult {
        webService.deleteProduct(productId)
    }

    suspend fun getProductCategories() = getResult {
        webService.getProductCategories()
    }

    suspend fun getProductSizes() = getResult {
        webService.getProductSizes()
    }

    suspend fun getProductBrands() = getResult {
        webService.getProductBrands()
    }

    suspend fun getProductByIdSku(productId: String, sku: Int) = getResult {
        webService.getProductByIdSku(productId, sku)
    }
}