package com.example.service

import com.example.core.iLocalDataSource.IAuthLocalDataSource
import com.example.core.iNetworkDataSource.IAuthNetwork
import com.example.core.iServices.IAuthService
import com.example.core.model.Authentication

class AuthServiceImpl(
    val localDataSource: IAuthLocalDataSource,
    val networkDataSource: IAuthNetwork
) : IAuthService {
    override fun login(auth: Authentication): Boolean {
        TODO("Not yet implemented")
    }
}