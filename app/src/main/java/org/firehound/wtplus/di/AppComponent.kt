package org.firehound.wtplus.di

import org.firehound.wtplus.di.modules.apiModule
import org.firehound.wtplus.di.modules.repoModule

val appComponent = listOf(
    apiModule,
    repoModule
)