package com.example.activity_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_choice).setOnClickListener{
            //透過Intent切換至SecActivity並傳遞requestCode作為識別編號
            val intent = Intent(this, SecActivity::class.java)
            startActivityForResult(intent,1)
        }
    }
    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let{
            //驗證發出對象，確認Activity執行的狀態
            if(requestCode == 1 && resultCode == Activity.RESULT_OK){
                //讀取Bundle的資料
                findViewById<TextView>(R.id.tv_meal).text =
                    "飲料：${it.getString("drink")}\n\n" +
                            "甜度：${it.getString("sugar")}\n\n" +
                            "冰塊：${it.getString("ice")}\n\n"

            }
        }
    }
}
