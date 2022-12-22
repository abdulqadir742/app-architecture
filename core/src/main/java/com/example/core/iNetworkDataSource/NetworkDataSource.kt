package com.example.core.iNetworkDataSource

import com.example.core.networkModel.Products
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://fakestoreapi.com"

interface NetworkDataSource {

    @GET("/products")
    fun getDataFromNetwork(): retrofit2.Call<List<Products>>

}
    object productService{
        val productInstance:NetworkDataSource

        init {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build()
            productInstance = retrofit.create(NetworkDataSource::class.java)


        }
    }


