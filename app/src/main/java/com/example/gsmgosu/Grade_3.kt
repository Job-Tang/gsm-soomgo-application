package com.example.gsmgosu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gsmgosu.retrofit.RetrofitService
import com.example.gsmgosu.retrofit.data.user.UserInfo
import kotlinx.android.synthetic.main.fragment_grade_3.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Grade_3 : Fragment() {

    lateinit var student : ArrayList<UserInfo>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_grade_3, container, false)

        RetrofitService().getUserAPI().getGradeInfo(3.toString()).enqueue(object :
            Callback<List<UserInfo>> {
            override fun onFailure(call: Call<List<UserInfo>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<UserInfo>>,
                response: Response<List<UserInfo>>
            ) {
                student = if(response.body() != null) {
                    response.body() as ArrayList<UserInfo>
                } else {
                    ArrayList()
                }
            }

        })

        view.third_grade.adapter = MyCustomAdapter(activity!!.applicationContext, student)
        // Inflate the layout for this fragment
        return view
    }

}