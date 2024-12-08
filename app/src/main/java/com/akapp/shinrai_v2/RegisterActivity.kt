package com.akapp.shinrai_v2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // 上記xmlを読み込む
        setContentView(R.layout.activity_register)

        // レイアウト上のViewを取得（必要に応じて使用）
        val frontButton = findViewById<Button>(R.id.front)
        val nextButton = findViewById<Button>(R.id.next)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        // 前へボタンのクリックイベント処理
//        frontButton.setOnClickListener{
//            // RegisterActivityの画面からMainActivityの画面に遷移
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
        // 次へボタンのクリックイベント処理
        nextButton.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, RegisterNameFragment())
                .commit()
        }
    }

}