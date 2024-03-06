package com.example.submissiondicodingpemula.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.submissiondicodingpemula.R

class AboutActivity : AppCompatActivity() {
    private lateinit var btnBack: Button

    fun instanceView() {
        btnBack = findViewById(R.id.btn_back_about)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        instanceView()

        btnBack.setOnClickListener {
            finish()
        }
    }

}