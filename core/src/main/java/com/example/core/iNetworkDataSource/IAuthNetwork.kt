package com.example.core.iNetworkDataSource

import com.example.core.model.Authentication

interface IAuthNetwork {
    fun login(auth: Authentication): Boolean
}