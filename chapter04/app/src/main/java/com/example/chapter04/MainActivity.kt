package com.example.chapter04

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.chapter04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        
        binding.goInputActivityButton.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }

        binding.deleteButton.setOnClickListener {
            deleteData()
        }

        binding.emergencyContactLayer.setOnClickListener {
            with(Intent(Intent.ACTION_VIEW)) {
                val phoneNumber = binding.emergencyContactValueTextView.text.toString()
                    .replace("-","")
                data = Uri.parse("tel:$phoneNumber")
                startActivity(this)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getDataAndUiUpdate()
    }

    private fun getDataAndUiUpdate() {
        with(getSharedPreferences( USER_INFORMATION, Context.MODE_PRIVATE)) {
            binding.nameValueTextView.text = getString(NAME, "")
            binding.bloodTypeValueTextView.text = getString(BLOOD_TYPE, "")
            binding.birthdateValueTextView.text = getString(BIRTHDATE, "")
            binding.emergencyContactValueTextView.text = getString(EMERGENCY_CONTACT, "")
            val warning = getString(WARNING, "")

            binding.cautionTextView.isVisible = !warning.isNullOrEmpty()
            binding.cautionValueTextView.isVisible = !warning.isNullOrEmpty()
            if (!warning.isNullOrEmpty()) {
                binding.cautionValueTextView.text = warning
            }
        }
    }

    private fun deleteData() {
        with(getSharedPreferences(USER_INFORMATION, Context.MODE_PRIVATE).edit()) {
            clear()
            apply()
        }
        getDataAndUiUpdate()
    }
}