package com.example.gsmgosu.retrofit.data.board

data class Board(
    val id : Int,
    val email : String,
    val grade : Int,
    val postTitle : String,
    val postContent : String,
    val publisher : String,
    val postDate : String
)