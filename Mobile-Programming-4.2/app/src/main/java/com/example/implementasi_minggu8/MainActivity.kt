package com.example.implementasi_minggu8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // EditText
        val editText = findViewById<EditText>(R.id.editText)
        val textButton = findViewById<Button>(R.id.textButton)
        textButton.setOnClickListener {
            val inputText = editText.text.toString()
            Toast.makeText(this, "Your name is $inputText", Toast.LENGTH_SHORT).show()
        }

        // CheckBox
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val checkButton = findViewById<Button>(R.id.checkButton)
        checkButton.setOnClickListener {
            val isChecked = checkBox.isChecked
            val resultText = if (isChecked) "a Human" else "an Alien"
            Toast.makeText(this, "You are $resultText", Toast.LENGTH_SHORT).show()
        }

        // RadioButtons
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioButton1 = findViewById<RadioButton>(R.id.radioButton1)
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        val radioButton3 = findViewById<RadioButton>(R.id.radioButton3)
        val radioButtonsButton = findViewById<Button>(R.id.radioButtonsButton)
        radioButtonsButton.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
            val selectedText = selectedRadioButton.text.toString()
            Toast.makeText(this, "Your legion is $selectedText", Toast.LENGTH_SHORT).show()
        }

        // Spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinnerButton = findViewById<Button>(R.id.spinnerButton)
        val spinnerValues = arrayOf("become master", "become evil lord", "enjoy normal life")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        spinner.adapter = spinnerAdapter
        spinnerButton.setOnClickListener {
            val selectedValue = spinner.selectedItem.toString()
            Toast.makeText(this, "You pick to $selectedValue", Toast.LENGTH_SHORT).show()
        }
    }
}