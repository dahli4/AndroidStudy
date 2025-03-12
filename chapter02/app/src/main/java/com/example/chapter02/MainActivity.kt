package com.example.chapter02

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val numberTextView = findViewById<TextView>(R.id.numberTextView)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val plusButton = findViewById<Button>(R.id.plusButton)

        resetButton.setOnClickListener() {
            Log.d("onClick", "리셋 버튼 클릭")
            numberTextView.text = "0"
        }

        plusButton.setOnClickListener() {
            val number = numberTextView.text.toString().toInt()
            numberTextView.text = (number + 1).toString()
        }
    }
}