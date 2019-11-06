package org.firehound.wtplus.di.modules

import org.firehound.wtplus.repo.CustomerRepo
import org.koin.dsl.module

val repoModule = module {
    factory { CustomerRepo(get()) }
}