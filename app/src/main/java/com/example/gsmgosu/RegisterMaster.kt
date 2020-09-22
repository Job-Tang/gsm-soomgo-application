package com.example.gsmgosu

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.example.gsmgosu.retrofit.RetrofitService
import com.example.gsmgosu.retrofit.data.user.Skill
import com.example.gsmgosu.retrofit.data.user.Token
import com.example.gsmgosu.retrofit.data.user.UserInfo
import kotlinx.android.synthetic.main.activity_register_master.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterMaster : AppCompatActivity() {
    private val grades = ArrayList<String>()
    private val classNumbers = ArrayList<String>()
    private val numbers = ArrayList<String>()
    val major = ArrayList<String>()

    val selectMajor = ArrayList<Skill>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_master)

        val intent = intent

        var grade = 0
        var classNumber = 0
        var number = 0

        val token = intent.getStringExtra("token")!!

        initData()
        val adapter = ArrayAdapter<Skill>(this, android.R.layout.simple_expandable_list_item_1, selectMajor)
        major_list.adapter = adapter

        spinner_grade.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                grade = p2
            }

        }

        spinner_field.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 != 0) {
                    if(!selectMajor.contains(Skill(major[p2]))){
                        selectMajor.add(Skill(major[p2]))
                        adapter.notifyDataSetChanged()
                    }

                }
            }

        }
        major_list.setOnItemClickListener{ adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
            val dialog = AlertDialog.Builder(this)
                .setTitle("지우시겠습니까?")
                .setPositiveButton("네") { dialogInterface : DialogInterface, position: Int ->
                    selectMajor.removeAt(i)
                    adapter.notifyDataSetChanged()
                }
                .setNegativeButton("아니오",null)

            dialog.show()
        }

        ok_button.setOnClickListener {

            RetrofitService().getUserAPI().getUserInfo(token).enqueue(object : Callback<UserInfo>{
                override fun onFailure(call: Call<UserInfo>, t: Throwable) {}

                override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                    if(grade == 0){
                        if(response.body()!!.grade != null) {
                            grade = response.body()!!.grade!!
                        }
                    }
                    if(classNumber == 0){
                        if(response.body()!!.student_class != null) {
                            classNumber = response.body()!!.student_class!!
                        }
                    }
                    if(number == 0){
                        if(response.body()!!.student_number != null) {
                            number = response.body()!!.student_number!!
                        }
                    }
                    RetrofitService().getUserAPI().patchUser(token, UserInfo(response.body()!!.email,response.body()!!.name,response.body()!!.image,grade,classNumber,number,selectMajor,response.body()!!.introduce)).enqueue(object : Callback<Token>{
                        override fun onFailure(call: Call<Token>, t: Throwable) {}

                        override fun onResponse(call: Call<Token>, response: Response<Token>) {
                            saveData(response.body()!!.access_token)
                        }

                    })
                }

            })

        }
        cancel_button.setOnClickListener {
            finish()
        }
    }

    private fun initData(){
        grades.add("학년")
        classNumbers.add("반")
        numbers.add("번호")
        major.add("분야")
        var i = 0
        while (i < 3){
            grades.add((++i).toString())
        }

        spinner_grade.adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,grades)

        i = 0
        while (i < 4){
            classNumbers.add((++i).toString())
        }

        spinner_class.adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,classNumbers)

        i = 0
        while (i < 21){
            numbers.add((++i).toString())
        }


        spinner_number.adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,numbers)

        major.add("모바일 앱")
        major.add("디자이너")
        major.add("웹")
        major.add("서버")
        major.add("클라우드")
        major.add("게임 개발")
        major.add("하드웨어")
        major.add("기타")


        spinner_field.adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, major)
    }
    fun saveData(token : String){
        val sharedPreference = getSharedPreferences("access_token", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putString("access_token",token)
        editor.apply()
    }
}