package com.example.app_architecture.user

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_architecture.adapter.UserAdapter
import com.example.app_architecture.databinding.ActivityDisplayingUserDataBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DisplayingUserData : AppCompatActivity() {

    lateinit var binding: ActivityDisplayingUserDataBinding
    private val userViewModel:UserViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDisplayingUserDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAdapter = UserAdapter(this)
        val recyclerView = binding.recyclerView
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)



        userViewModel.getDataFromDatabase().observe(this, Observer {user ->
            myAdapter.setData(user)
        })
    }
}