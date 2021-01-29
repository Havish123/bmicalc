package com.havish.kotlinpractice

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private lateinit var status:Button
    private lateinit var button: Button
    private lateinit var weight:EditText
    private lateinit var height:EditText
    private lateinit var age:EditText
    private  lateinit var weightText:TextView
    private  lateinit var heightText:TextView
    private  lateinit var ageText:TextView
    private  lateinit var bmiText:TextView
    private  lateinit var bottomlayout:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomlayout=findViewById(R.id.bottom_linear)
        bottomlayout.visibility=View.GONE
        OnclickButton();
    }

    private fun OnclickButton() {
        button=findViewById(R.id.bmibtn)
        weight=findViewById(R.id.weight)
        height=findViewById(R.id.Height)
        age=findViewById(R.id.age)
        weightText=findViewById(R.id.weightText)
        heightText=findViewById(R.id.heightText)
        ageText=findViewById(R.id.agetext)
        bmiText=findViewById(R.id.bmi)
        status=findViewById(R.id.status)

        button.setOnClickListener(View.OnClickListener {
            Se.weight=weight.text.toString()
            Se.height=height.text.toString()
            Se.age=age.text.toString()
            var square=Se.height.toDouble()*Se.height.toDouble()
            var ans=Se.weight.toFloat()/square.toFloat()
            weightText.text=weightText.text.toString()+Se.weight
            heightText.text=heightText.text.toString()+Se.height
            ageText.text=ageText.text.toString()+Se.age
            bmiText.text=bmiText.text.toString()+ans

            if(ans<18.5){
                status.setTextColor(Color.BLACK)
                status.setText("Underweight")
                status.setBackgroundColor(Color.RED)
            }
            else if(ans>18.5 && ans<24.9){
                status.setTextColor(Color.BLACK)
                status.setText("Normal")
                status.setBackgroundColor(Color.GREEN)
            }
            else{
                status.setTextColor(Color.BLACK)
                status.setText("Overweight")
                status.setBackgroundColor(Color.YELLOW)
            }
            bottomlayout.visibility=View.VISIBLE
        })

    }


}