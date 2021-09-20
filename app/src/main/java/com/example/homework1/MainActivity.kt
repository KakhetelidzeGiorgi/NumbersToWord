package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    lateinit var btnConvert: Button
    lateinit var resultTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        editText = findViewById(R.id.editTxtView)
        btnConvert = findViewById(R.id.convertBtnView)
        resultTxt = findViewById(R.id.resultTxtView)

        btnConvert.setOnClickListener {
            val converter = NumbersToWord()
            val inputValue = editText.text.toString()

            if (inputValue.isDigitsOnly()) {
                val convertedNum = converter.numToWord(inputValue.toInt())
                resultTxt.text = convertedNum
            } else
                resultTxt.text = INVALID_VALUE

        }
    }

    companion object {
        const val INVALID_VALUE = "Input value is not Int number"
    }

}