package com.example.chapter04

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.chapter04.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bloodTypeSpinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.blood_types,
            android.R.layout.simple_list_item_1
        )

        binding.birthdateLayer.setOnClickListener {
            val listner = OnDateSetListener { _, year, month, dayOfMonth ->
                binding.birthdateValueTextView.text = "$year-${month + 1}-$dayOfMonth"
            }
            DatePickerDialog(
                this,
                listner,
                2000,
                1,
                1
            ).show()
        }

        binding.warningCheckBox.setOnCheckedChangeListener { _, isChecked ->
            binding.cautionValueTextView.isVisible = isChecked
        }

        binding.cautionValueTextView.isVisible = binding.warningCheckBox.isChecked

        binding.saveButton.setOnClickListener {
            saveData()
            finish()
        }
    }

    private fun saveData() {
        with(getSharedPreferences(USER_INFORMATION, Context.MODE_PRIVATE).edit()) {
            putString(NAME, binding.nameValueEditText.text.toString())
            putString(BLOOD_TYPE, getBloodType())
            putString(EMERGENCY_CONTACT, binding.emergencyContactValueEditText.text.toString())
            putString(BIRTHDATE, binding.birthdateTextView.text.toString())
            putString(WARNING, getWarning())
            apply()
        }
        Toast.makeText(this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show()
    }

    private fun getBloodType(): String {
        val bloodAlphabet = binding.bloodTypeSpinner.selectedItem.toString()
        val bloodSign = if (binding.bloodTypePlusRadioButton.isChecked) "+" else "-"
        return "$bloodSign$bloodAlphabet"

    }

    private fun getWarning(): String {
        return if (binding.warningCheckBox.isChecked) binding.cautionValueTextView.text.toString() else ""
    }
}