package com.example.app_architecture.auth

import com.example.core.iServices.IAuthService
import com.example.core.model.Authentication

class AuthViewModel(val service: IAuthService) {

    fun login(auth: Authentication) {
        service.login(auth)
    }
}