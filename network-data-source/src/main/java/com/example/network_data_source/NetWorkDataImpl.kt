package com.example.network_data_source

import com.example.core.iNetworkDataSource.NetworkDataSource
import com.example.core.iNetworkDataSource.productService
import com.example.core.networkModel.Products

class NetWorkDataImpl:NetworkDataSource {

    override fun getDataFromNetwork(): retrofit2.Call<List<Products>> {
        return productService.productInstance.getDataFromNetwork()
    }



}