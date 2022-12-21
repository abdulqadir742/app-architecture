package com.example.app_architecture.user
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app_architecture.databinding.ActivityMainBinding
import com.example.core.model.User
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
     private val userViewModel: UserViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInsert.setOnClickListener{
            val name = binding.userName.text.toString()
            val email = binding.userEmail.text.toString()
            val address = binding.userAddress.text.toString()
            val phone = binding.userPhone.text.toString()

            val user = User(0,name,email,address,phone)
            userViewModel.addUser(user)
        }
    }
}