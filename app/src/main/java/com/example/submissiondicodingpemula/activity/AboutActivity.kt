package com.example.submissiondicodingpemula.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.submissiondicodingpemula.R
import com.example.submissiondicodingpemula.databinding.ActivityAboutBinding
import com.example.submissiondicodingpemula.databinding.ActivityDetailBinding

class AboutActivity : AppCompatActivity() {
//    private lateinit var btnBack: Button
    private lateinit var binding: ActivityAboutBinding


//    fun instanceView() {
//        btnBack = findViewById(R.id.btn_back_about)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_about)

//        instanceView()

        binding.btnBackAbout.setOnClickListener {
            finish()
        }
    }

}