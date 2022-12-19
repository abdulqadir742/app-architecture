package com.example.core.iLocalDataSource

import com.example.core.model.Authentication

interface IAuthLocalDataSource {
    fun login(auth: Authentication): Boolean
}