package com.akapp.shinrai_v2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        //　画面遷移用ボタンの取得
//        val btn_start = findViewById<Button>(R.id.btn_start)
//        //　フラグメント画面遷移用のボタンにリスナを登録
//        btn_start.setOnClickListener{
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.main, RegisterFragment()) // RegisterFragmentに転換
//                .addToBackStack(null) //バックスタック追加
//                .commit()
//        }
        val btn_start = findViewById<Button>(R.id.btn_start) // start 버튼을 레이아웃에서 참조
        btn_start.setOnClickListener {
            // RegisterTest Activity로 화면전환
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}