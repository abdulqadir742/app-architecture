package com.example.app_architecture

import android.app.Application
import com.example.app_architecture.user.UserViewModel
import com.example.core.iLocalDataSource.UserLocalDataSource
import com.example.core.iNetworkDataSource.NetworkDataSource
import com.example.core.iServices.UserService
import com.example.local_data_source.UserDatabase
import com.example.local_data_source.UserLocalDataImpl
import com.example.network_data_source.NetWorkDataImpl
import com.example.service.UserServiceImpl
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

         val userDao = UserDatabase.getDatabase(this).userDao()

         val diModule = module {
            factory<UserLocalDataSource> { UserLocalDataImpl(userDao) }
            factory<UserService> { UserServiceImpl(get(),get()) }
            factory<NetworkDataSource> { NetWorkDataImpl() }
            factory { UserViewModel(get()) }
        }

        startKoin {
            modules(diModule)
        }
    }


}

