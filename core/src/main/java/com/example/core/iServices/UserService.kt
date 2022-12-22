package com.example.core.iServices

import androidx.lifecycle.LiveData
import com.example.core.model.User
import com.example.core.networkModel.Products
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    suspend fun addUser(user: User)

    fun getDataFromDatabase(): LiveData<List<User>>

    @GET("/products")
    fun getDataFromNetwork(): retrofit2.Call<List<Products>>
}