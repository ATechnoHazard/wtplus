package org.firehound.wtplus.api.product

import org.firehound.wtplus.models.product.Product
import retrofit2.Response
import retrofit2.http.*

interface ProductWebService {
    @GET("products")
    suspend fun getAllProducts(): Response<List<Product>>

    @GET("products/{productId}")
    suspend fun getProductById(@Path("productId") productId: String): Response<Product>

    @POST("products/create")
    suspend fun createProduct(@Body product: Product): Response<String>

    @PUT("products/{productId}/update")
    suspend fun updateProduct(@Path("productId") productId: String, @Body product: Product):
            Response<String>

    @DELETE("products/{productId}/delete")
    suspend fun deleteProduct(@Path("productId") productId: String): Response<String>

    @GET("products/productcategory")
    suspend fun getProductCategories(): Response<List<String>>

    @GET("products/productsize")
    suspend fun getProductSizes(): Response<List<Int>>

    @GET("products/productbrand")
    suspend fun getProductBrands(): Response<List<String>>

    @GET("products/{productId}/product_sku/{SKU}")
    suspend fun getProductByIdSku(
        @Path("productId") productId: String,
        @Path("SKU") sku: Int
    ): Response<Product>
}