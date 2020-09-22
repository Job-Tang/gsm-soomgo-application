package com.example.gsmgosu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_grade_2.view.*

class Grade_2 : Fragment() {

    lateinit var student : ArrayList<Student>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_grade_2, container, false)
        // Inflate the layout for this fragment



        view.second_grade.adapter = MyCustomAdapter(activity!!.applicationContext, student)

        return view
    }
    
}