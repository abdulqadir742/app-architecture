package com.example.core.iLocalDataSource

import androidx.lifecycle.LiveData
import com.example.core.model.User

interface UserLocalDataSource {

    suspend fun addUser(user: User)

    fun getDataFromDatabase(): LiveData<List<User>>
}