package com.example.bestapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val start_second_activity = findViewById<Button>(R.id.start_second_activity)

        start_second_activity.setOnClickListener{
            val intent = Intent (this,MovieDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}