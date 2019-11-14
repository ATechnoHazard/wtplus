package org.firehound.wtplus.repo

import org.firehound.wtplus.api.product.ProductWebClient
import org.firehound.wtplus.models.product.Product

class ProductRepo(
    private val webClient: ProductWebClient
) : BaseRepo() {
    fun getAllProducts() = makeRequest {
        webClient.getAllProducts()
    }

    fun getProductsById(productId: String) = makeRequest {
        webClient.getProductById(productId)
    }

    fun createProduct(product: Product) = makeRequest {
        webClient.createProduct(product)
    }

    fun updateProduct(productId: String, product: Product) = makeRequest {
        webClient.updateProduct(productId, product)
    }

    fun deleteProduct(productId: String) = makeRequest {
        webClient.deleteProduct(productId)
    }

    fun getProductCategories() = makeRequest {
        webClient.getProductCategories()
    }

    fun getProductSizes() = makeRequest {
        webClient.getProductSizes()
    }

    fun getProductBrands() = makeRequest {
        webClient.getProductBrands()
    }

    fun getProductByIdSku(productId: String, sku: Int) = makeRequest {
        webClient.getProductByIdSku(productId, sku)
    }
}