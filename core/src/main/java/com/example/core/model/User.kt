package com.example.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val user_name: String,
    val user_mail: String,
    val user_address: String,
    val user_no: String
)
