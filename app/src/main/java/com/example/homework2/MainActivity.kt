package com.example.homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val input: EditText = findViewById(R.id.input)
        val output: TextView = findViewById(R.id.output)
        button.setOnClickListener{
            var num: Int
            try{
                num = input.text.toString().toInt()
                if(num < 1){
                    num = 1
                    input.setText("1")
                }
                if(num > 1000){
                    num = 1000;
                    input.setText("1000")
                }
                output.text = numToWord(num)
            }
            catch(e: Exception){
                output.text = "რიცხვის ფორმატი არასწორია ან ზედმეტად დიდია"
            }
        }
    }
    private fun numToWord(num: Int): String{
        if(num == 1000)
            return "ათასი"
        var hundredsPart = ""
        var decimalPart = ""
        var unitPart = ""
        val num1: Int = num/100
        val num2: Int = (num%100)/20
        val num3: Int = num%20
        hundredsPart = when(num1){
            1 -> "ას"
            2 -> "ორას"
            3 -> "სამას"
            4 -> "ოთხას"
            5 -> "ხუთას"
            6 -> "ექვსას"
            7 -> "შვიდას"
            8 -> "რვაას"
            9 -> "ცხრაას"
            else -> ""
        }
        if(num3 == 0 && num2 == 0)
            return hundredsPart + "ი"
        if(num3 != 0)
            decimalPart = when(num2){
                1 -> "ოცდა"
                2 -> "ორმოცდა"
                3 -> "სამოცდა"
                4 -> "ოთხმოცდა"
                else -> ""
            }
        else
            decimalPart = when(num2){
                1 -> "ოცი"
                2 -> "ორმოცი"
                3 -> "სამოცი"
                4 -> "ოთხმოცი"
                else -> ""
            }

        unitPart = when(num3){
            1 -> "ერთი"
            2 -> "ორი"
            3 -> "სამი"
            4 -> "ოთხი"
            5 -> "ხუთი"
            6 -> "ექვსი"
            7 -> "შვიდი"
            8 -> "რვა"
            9 -> "ცხრა"
            10 -> "ათი"
            11 -> "თერთმეტი"
            12 -> "თორმეტი"
            13 -> "ცამეტი"
            14 -> "თოთხმეტი"
            15 -> "თხუტმეტი"
            16 -> "თექვსმეტი"
            17 -> "ჩვიდმეტი"
            18 -> "თვრამეტი"
            19 -> "ცხრამეტი"
            else -> ""
        }
        if(num1 == 0)
            return "$decimalPart$unitPart"
        return "$hundredsPart $decimalPart$unitPart"
    }
}