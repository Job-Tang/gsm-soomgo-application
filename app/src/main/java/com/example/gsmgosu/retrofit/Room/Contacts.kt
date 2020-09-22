package com.example.gsmgosu.retrofit.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_contacts")
data class Contacts(
    @PrimaryKey(autoGenerate = true)
    var onePoint : String,
    var gitHub : String,
    var skills : String
)