package com.br.imobi.di

import com.br.home.di.featureHomeModule
import com.br.remote.di.createRemoteModule

val appComponent = listOf(createRemoteModule(""), featureHomeModule)