package com.example.network_data_source

import com.example.core.iNetworkDataSource.NetworkDataSource
import com.example.core.iNetworkDataSource.productService
import com.example.core.iServices.UserService
import com.example.core.networkModel.Products
import retrofit2.Response

class NetWorkDataImpl:NetworkDataSource {

    override fun getDataFromNetwork(): retrofit2.Call<List<Products>> {
        val product = productService.productInstance.getDataFromNetwork()
        return product
    }



}