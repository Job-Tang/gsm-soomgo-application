package com.example.gsmgosu.retrofit

import com.example.gsmgosu.BuildConfig
import com.example.gsmgosu.retrofit.api.BoardAPI
import com.example.gsmgosu.retrofit.api.UserAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUserAPI() : UserAPI{
        return retrofit.create(UserAPI::class.java)
    }
    fun getBoardAPI() : BoardAPI{
        return retrofit.create(BoardAPI::class.java)
    }
}