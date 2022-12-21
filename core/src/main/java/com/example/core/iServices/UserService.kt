package com.example.core.iServices

import androidx.lifecycle.LiveData
import com.example.core.model.User

interface UserService {
    suspend fun addUser(user: User)

    fun getDataFromDatabase(): LiveData<List<User>>
}