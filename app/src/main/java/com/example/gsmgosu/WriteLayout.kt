package com.example.gsmgosu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gsmgosu.retrofit.RetrofitService
import com.example.gsmgosu.retrofit.data.board.Board
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WriteLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_layout)

        RetrofitService().getBoardAPI().postBoard().enqueue(object : Callback<Board>{
            override fun onResponse(call: Call<Board>, response: Response<Board>) {

            }

            override fun onFailure(call: Call<Board>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}