package org.firehound.wtplus.repo

import org.firehound.wtplus.api.product.ProductWebClient
import org.firehound.wtplus.models.product.Product

class ProductRepo(
    private val webClient: ProductWebClient
) : BaseRepo() {
    suspend fun getAllProducts() = makeRequest {
        webClient.getAllProducts()
    }

    suspend fun getProductsById(productId: String) = makeRequest {
        webClient.getProductById(productId)
    }

    suspend fun createProduct(product: Product) = makeRequest {
        webClient.createProduct(product)
    }

    suspend fun updateProduct(productId: String, product: Product) = makeRequest {
        webClient.updateProduct(productId, product)
    }

    suspend fun deleteProduct(productId: String) = makeRequest {
        webClient.deleteProduct(productId)
    }

    suspend fun getProductCategories() = makeRequest {
        webClient.getProductCategories()
    }

    suspend fun getProductSizes() = makeRequest {
        webClient.getProductSizes()
    }

    suspend fun getProductBrands() = makeRequest {
        webClient.getProductBrands()
    }

    suspend fun getProductByIdSku(productId: String, sku: Int) = makeRequest {
        webClient.getProductByIdSku(productId, sku)
    }
}