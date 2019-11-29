package org.firehound.wtplus.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.firehound.wtplus.models.product.Product
import org.firehound.wtplus.repo.ProductRepo
import org.firehound.wtplus.utils.round

class ProductViewModel(private val repo: ProductRepo) : ViewModel() {
    fun getAllProducts() = repo.getAllProducts()

    fun getCartTotal(): Float {
        var total = 0.0f
        cartItems.forEach { product ->
            total += product.productPrice!!
        }
        return total.round(2)
    }

    fun addToCart(product: Product): Boolean {
        for (item in cartItems) {
            if (item.productId == product.productId && item.savedSize == product.savedSize) {
                return false
            }
        }
        cartItems.add(product)
        cartLiveData.postValue(cartItems)
        return true
    }

    lateinit var selectedProduct: Product

    private var cartItems: MutableList<Product> = mutableListOf()

    var cartLiveData: MutableLiveData<List<Product>> = MutableLiveData()
}