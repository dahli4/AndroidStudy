package com.example.part3.chapter07

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.part3.chapter07.databinding.ActivityMainBinding

class InputActivity :AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}