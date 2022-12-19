package com.example.core.iServices

import com.example.core.model.Authentication

interface IAuthService {
    fun login(auth: Authentication): Boolean
}