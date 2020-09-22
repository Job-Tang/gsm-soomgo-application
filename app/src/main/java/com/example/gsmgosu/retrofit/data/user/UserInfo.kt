package com.example.gsmgosu.retrofit.data.user

data class UserInfo(
    val email : String,
    val name : String,
    val image : String,
    val grade : Int,
    val student_class : Int,
    val student_number : Int,
    val skills : ArrayList<String>,
    val introduce : String
)