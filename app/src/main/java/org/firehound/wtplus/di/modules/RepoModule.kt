package org.firehound.wtplus.di.modules

import org.firehound.wtplus.repo.CustomerRepo
import org.firehound.wtplus.repo.ProductRepo
import org.koin.dsl.module

val repoModule = module {
    factory { CustomerRepo(get()) }
    factory { ProductRepo(get()) }
}