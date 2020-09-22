package com.example.gsmgosu.retrofit.Room.DAO

import androidx.room.Insert
import androidx.room.Query
import com.example.gsmgosu.retrofit.Room.Contacts

interface ContactsDao {
    @Query("SELECT * FROM tb_contacts")
    fun getAll() : List<Contacts>

}