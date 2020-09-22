package com.example.gsmgosu.retrofit.api

import com.example.gsmgosu.retrofit.data.Message
import com.example.gsmgosu.retrofit.data.board.Board
import retrofit2.Call
import retrofit2.http.*

interface BoardAPI {
    @GET("board")
    fun getBoard(
        @Query("gradeFilter") gradeFilter : String
    ) : Call<Board>

    @POST("board")
    fun postBoard(
        @Query("access_token") access_token : String
    ) : Call<Message>

    @PATCH("user")
    fun patchBoard(
        @Query("access_token") access_token: String,
        @Query("id") id : String,
        @Field("grade") grade : Int,
        @Field("postTitle") postTitle : String,
        @Field("postContent") postContent : String,
        @Field("publisher") publisher : String
    ) : Call<Message>

    @DELETE("board")
    fun deleteBoard(
        @Query("access_token") access_token: String,
        @Query("id") id: String
    ) : Call<Message>
}