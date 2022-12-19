package com.example.local_data_source

import com.example.core.iLocalDataSource.IAuthLocalDataSource
import com.example.core.model.Authentication

class AuthLocalDataImpl:IAuthLocalDataSource {
    override fun login(auth: Authentication): Boolean {
        TODO("Not yet implemented")
    }

}