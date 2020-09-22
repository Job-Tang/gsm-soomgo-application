package com.example.gsmgosu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_user_setting.*

class UserSetting : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_setting)

        // 뒤로가기
        myPage_Back.setOnClickListener { this.finish() }

        // 로그아웃
        myPage_LogOut.setOnClickListener {
            //파이어베이스 로그아웃 하는 코드
            alert("로그아웃")
        }

        // 내정보
        myPage_MyProfile.setOnClickListener { startActivity(Intent(applicationContext, MyProfile::class.java)) }

        myPage_DeleteUser.setOnClickListener {// 회원 탈퇴하는 코드
            alert("회원탈퇴")

        }
    }

    private fun alert(type: String) {
        var string = ""
        when(type){
            "로그아웃" -> string = "로그아웃 하시겠습니까?"
            "회원탈퇴" -> string = "정말 회원 탈퇴하시겠습니까?"
        }
        val builder = AlertDialog.Builder(this@UserSetting)
            .setMessage(string)
            .setPositiveButton("예"){dialog, which ->
            // Do something when user press the positive button
                if(type == "로그아웃"){
                    FirebaseAuth.getInstance().signOut()
                    Toast.makeText(applicationContext,"로그아웃 완료",Toast.LENGTH_SHORT).show()
                }
                else{
                    FirebaseAuth.getInstance().currentUser?.delete()
                    Toast.makeText(applicationContext,"회원탈퇴 완료",Toast.LENGTH_SHORT).show()
                }
                restart()
            }
            .setNegativeButton("아니오"){dialog,which ->
            Toast.makeText(applicationContext,"${type} 취소",Toast.LENGTH_SHORT).show()
            }

        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
    }

    private fun restart() {
        finishAffinity()
        val intent = Intent(this, SplashActivity::class.java)
        startActivity(intent)
        System.exit(0)


    }
}