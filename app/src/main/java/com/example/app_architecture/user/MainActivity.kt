package com.example.app_architecture.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_architecture.databinding.ActivityMainBinding
import com.example.core.iNetworkDataSource.NetworkDataSource
import com.example.core.model.User
import com.example.core.networkModel.Products
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInsert.setOnClickListener {
            val name = binding.userName.text.toString()
            val email = binding.userEmail.text.toString()
            val address = binding.userAddress.text.toString()
            val phone = binding.userPhone.text.toString()

            val user = User(0, name, email, address, phone)
            userViewModel.addUser(user)

            binding.userName.setText("")
            binding.userEmail.setText("")
            binding.userAddress.setText("")
            binding.userPhone.setText("")
        }


        //Get Data from Database
        userViewModel.getDataFromDatabase().observe(this, Observer { user ->
            Log.d("main", "My Data $user\n")
        })


        //get Data From Network
        val myProducts = userViewModel.getDataFromNetwork()
        myProducts.enqueue(object : Callback<List<Products>> {
            override fun onResponse(
                call: Call<List<Products>>,
                response: Response<List<Products>>
            ) {
                val product = response.body()
                if (product != null) {
                    Log.d("main", "My Products $product")
                }
            }
            override fun onFailure(call: Call<List<Products>>, t: Throwable) {
                Log.d("main", " Failed")
            }
        })


    }
}








