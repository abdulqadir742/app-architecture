package com.example.service

import androidx.lifecycle.LiveData
import com.example.core.iLocalDataSource.UserLocalDataSource
import com.example.core.iServices.UserService
import com.example.core.model.User

class UserServiceImpl(private val localDataSource: UserLocalDataSource):UserService {
    override suspend fun addUser(user: User) {
        localDataSource.addUser(user)

    }

    override fun getDataFromDatabase(): LiveData<List<User>> {
       return localDataSource.getDataFromDatabase()
    }
}