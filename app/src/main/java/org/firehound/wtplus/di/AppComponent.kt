package org.firehound.wtplus.di

import org.firehound.wtplus.di.modules.apiModule
import org.firehound.wtplus.di.modules.repoModule
import org.firehound.wtplus.di.modules.viewModelModule

val appComponent = listOf(
    apiModule,
    repoModule,
    viewModelModule
)