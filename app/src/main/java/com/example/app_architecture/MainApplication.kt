package com.example.app_architecture

import android.app.Application
import com.example.app_architecture.user.UserViewModel
import com.example.core.iLocalDataSource.UserLocalDataSource
import com.example.core.iNetworkDataSource.IAuthNetwork
import com.example.core.iServices.UserService
import com.example.local_data_source.UserDatabase
import com.example.local_data_source.UserLocalDataImpl
import com.example.network_data_source.AuthNetworkImpl
import com.example.service.UserServiceImpl
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication : Application() {
    private val userDao = UserDatabase.getDatabase(this).userDao()
    override fun onCreate() {
        super.onCreate()
        startKoin {
            diModule
        }
    }

    private val diModule = module {
        factory<UserLocalDataSource> { UserLocalDataImpl(userDao) }
        factory<UserService> { UserServiceImpl(get()) }
        factory<IAuthNetwork> { AuthNetworkImpl() }
        factory { UserViewModel(get()) }
        factory<UserService> { UserServiceImpl(get()) }
    }
}

