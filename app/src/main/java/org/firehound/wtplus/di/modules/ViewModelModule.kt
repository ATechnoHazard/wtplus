package org.firehound.wtplus.di.modules

import org.firehound.wtplus.ui.cart.CartViewModel
import org.firehound.wtplus.ui.home.ProductViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProductViewModel(get()) }
    viewModel { CartViewModel(get()) }
}