package org.firehound.wtplus.ui.home

import androidx.lifecycle.ViewModel
import org.firehound.wtplus.models.product.Product
import org.firehound.wtplus.repo.ProductRepo

class ProductViewModel(private val repo: ProductRepo) : ViewModel() {
    fun getAllProducts() = repo.getAllProducts()
    lateinit var selectedProduct: Product
}