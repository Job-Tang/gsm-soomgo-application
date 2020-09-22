package com.example.gsmgosu.retrofit.api

import com.example.gsmgosu.retrofit.data.Message
import com.example.gsmgosu.retrofit.data.user.Token
import com.example.gsmgosu.retrofit.data.user.UserInfo
import retrofit2.Call
import retrofit2.http.*

interface UserAPI {
    @GET("user")
    fun getUserInfo(
        @Query("access_token") access_token : String
    ) : Call<UserInfo>

    @GET("users")
    fun getGradeInfo(
        @Query("gradeFilter") gradeFilter : String
    ) : Call<List<UserInfo>>

    @FormUrlEncoded
    @POST("user")
    fun setUserInfo(
        @Body user : UserInfo
    ) : Call<Token>
    @PATCH("user")
    fun patchUser(
        @Query("access_token") access_token: String,
        @Body userInfo: UserInfo
    ) : Call<Token>
    @DELETE("user")
    fun deleteUser(
        @Query("access_token") access_token: String
    ) : Call<Message>
}