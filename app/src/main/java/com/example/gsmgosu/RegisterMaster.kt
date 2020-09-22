package com.example.gsmgosu

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_register_master.*

class RegisterMaster : AppCompatActivity() {
    private val grade = ArrayList<String>()
    private val classNumber = ArrayList<String>()
    private val number = ArrayList<String>()
    val major = ArrayList<String>()

    val selectMajor = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_master)

        initData()
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, selectMajor)
        major_list.adapter = adapter

        spinner_field.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 != 0) {
                    selectMajor.add(major[p2])
                    adapter.notifyDataSetChanged()
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

    }

    private fun initData(){
        grade.add("학년")
        classNumber.add("반")
        number.add("번호")
        major.add("분야")
        var i = 0
        while (i < 3){
            grade.add((++i).toString())
        }

        spinner_grade.adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,grade)

        i = 0
        while (i < 4){
            classNumber.add((++i).toString())
        }

        spinner_class.adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,classNumber)

        i = 0
        while (i < 21){
            number.add((++i).toString())
        }


        spinner_number.adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,number)

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
}