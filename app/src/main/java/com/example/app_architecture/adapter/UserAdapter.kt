package com.example.app_architecture.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.app_architecture.databinding.ListViewBinding
import com.example.core.model.User

class UserAdapter(private val context: Context) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private var list = emptyList<User>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var userList = list[position]
        holder.name.text = userList.user_name
        holder.email.text = userList.user_mail
        holder.address.text = userList.user_address
        holder.phone.text = userList.user_no

        holder.listItem.setOnClickListener {
            Toast.makeText(context,"User Name is ${userList.user_name}",Toast.LENGTH_SHORT).show()
        }

    }

    class MyViewHolder(binding: ListViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val listItem = binding.listItems
        val name = binding.uName
        val email = binding.uEmail
        val address = binding.uAddress
        val phone = binding.uPhone

    }

    fun setData(user : List<User>)
    {
        this.list = user
        notifyDataSetChanged()
    }

}