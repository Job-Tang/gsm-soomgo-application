package com.example.gsmgosu.retrofit.data.user

data class UserInfo(
    val email : String,
    val name : String,
    val image : String,
    val grade : Int? = null,
    val student_class : Int? = null,
    val student_number : Int? = null,
    val skills : List<Skill>? = null,
    val introduce : String? = null
)

data class Skill(
    val skill: String
)