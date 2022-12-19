package com.example.app_architecture

import android.app.Application
import com.example.core.iLocalDataSource.IAuthLocalDataSource
import com.example.core.iNetworkDataSource.IAuthNetwork
import com.example.core.iServices.IAuthService
import com.example.local_data_source.AuthLocalDataImpl
import com.example.network_data_source.AuthNetworkImpl
import com.example.service.AuthServiceImpl
import org.koin.dsl.module

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

    }

    val diModule = module {
        factory<IAuthLocalDataSource> { AuthLocalDataImpl() }
        factory<IAuthService> { AuthServiceImpl(get(), get()) }
        factory<IAuthNetwork> { AuthNetworkImpl() }
    }
}