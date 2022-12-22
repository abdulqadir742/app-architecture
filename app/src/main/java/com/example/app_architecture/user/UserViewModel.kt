package com.example.app_architecture.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.iServices.UserService
import com.example.core.model.User
import com.example.core.networkModel.Products
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class UserViewModel(private val service: UserService):ViewModel() {

      fun addUser(user: User) {
         viewModelScope.launch(Dispatchers.IO) {
             service.addUser(user)
         }
     }

    fun getDataFromDatabase(): LiveData<List<User>>{
       return service.getDataFromDatabase()
    }

    fun getDataFromNetwork(): Call<List<Products>> {
        return service.getDataFromNetwork()
    }
}