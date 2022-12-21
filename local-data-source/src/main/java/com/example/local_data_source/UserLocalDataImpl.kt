package com.example.local_data_source

import androidx.lifecycle.LiveData
import com.example.core.iLocalDataSource.UserLocalDataSource
import com.example.core.model.User

class UserLocalDataImpl(private val userDao: UserDao):UserLocalDataSource {
    override suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    override fun getDataFromDatabase(): LiveData<List<User>> {
        return userDao.getDataFromDatabase()
    }
}