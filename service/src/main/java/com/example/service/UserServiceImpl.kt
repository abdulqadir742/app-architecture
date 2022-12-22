package com.example.service

import androidx.lifecycle.LiveData
import com.example.core.iLocalDataSource.UserLocalDataSource
import com.example.core.iNetworkDataSource.NetworkDataSource
import com.example.core.iServices.UserService
import com.example.core.model.User
import com.example.core.networkModel.Products
import retrofit2.Response

class UserServiceImpl(private val localDataSource: UserLocalDataSource,val networkDataSource: NetworkDataSource):UserService {
    override suspend fun addUser(user: User) {
        localDataSource.addUser(user)

    }

    override fun getDataFromDatabase(): LiveData<List<User>> {
       return localDataSource.getDataFromDatabase()
    }

    override fun getDataFromNetwork(): retrofit2.Call<List<Products>> {
        return networkDataSource.getDataFromNetwork()
    }


}