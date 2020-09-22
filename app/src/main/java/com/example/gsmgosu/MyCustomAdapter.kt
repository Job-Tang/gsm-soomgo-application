package com.example.gsmgosu

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.gsmgosu.retrofit.data.user.Skill
import com.example.gsmgosu.retrofit.data.user.UserInfo
import kotlinx.android.synthetic.main.activity_main.view.*

class MyCustomAdapter(context: Context, dataList : ArrayList<UserInfo>) : BaseAdapter() {
    private val mContext : Context = context

    var mDataList = dataList


    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(mContext)
        val rowMain = layoutInflater.inflate(R.layout.student_impo, parent,false)
        val studentText = rowMain.findViewById<TextView>(R.id.student_class)
        studentText.text = mDataList[position].name
        val studentImage = rowMain.findViewById<ImageView>(R.id.imageView2)
        studentImage.setImageResource(R.drawable.boy)
        val studentSkills  = rowMain.findViewById<TextView>(R.id.student_skills)
        var skill = ""
        for (s : Skill in mDataList[position].skills!!){
            skill += s.skill
        }

        studentSkills.text = skill

        return rowMain
    }


    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return mDataList.size
    }

}