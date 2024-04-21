package com.example.bmi


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.bmi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        //setContentView(R.layout.activity_main)
       // val weightText =findViewById<EditText>(R.id.etweight)
        //val heightText =findViewById<EditText>(R.id.etheight)
        //val calcButton = findViewById<Button>(R.id.btncalculate)
        binding.btncalculate.setOnClickListener {
            val weight = binding.etweight.text.toString()
            val height = binding.etheight.text.toString()

            val bmi=weight.toFloat()/((height.toFloat()/100)*(height.toFloat()/100))
            val bmi2dig = String.format("%.2f",bmi).toFloat()
            displayresult(bmi2dig)
        }

    }


    private fun displayresult(bmi:Float){
        val resultIndex = findViewById<TextView>(R.id.bmi)
        val resultDescription = findViewById<TextView>(R.id.result)
        resultIndex.text=bmi.toString()
        var resultText=" "
        var color =0
        when {
            bmi < 18.56 ->{
                resultText="Underweight"
                color=R.color.under_weight
            }
            bmi < 25 -> {
                resultText="Normal"
                color=R.color.normal
            }
            bmi < 29 -> {
                resultText="Overweight"
                color = R.color.over_weight
            }
            else -> {
                resultText="Obese"
                color=R.color.obese
            }

        }
        resultDescription.setTextColor(ContextCompat.getColor(this,color))
        resultDescription.text=resultText

    }
    }


