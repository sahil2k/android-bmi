package com.bitamirshafiee.bmiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate_button.setOnClickListener {

            if (weight_edit_text.text.isNotEmpty() && height_edit_text.text.isNotEmpty()) {
                calculateBMI()
            } else {
                Toast.makeText(this, "enter the needed field", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateBMI(){
        val weight = weight_edit_text.text.toString().toFloat()
        val height = height_edit_text.text.toString().toFloat()

        val myBMI = weight / (height * height)

        bmi_text_view.text = myBMI.toString()

        if (myBMI < 18.5) {
            bmi_image_view.setImageResource(R.drawable.underweight)
        } else if (myBMI >= 18.5 && myBMI < 24.9) {
            bmi_image_view.setImageResource(R.drawable.healthy)
        } else if (myBMI >= 24.9 && myBMI < 29.9) {
            bmi_image_view.setImageResource(R.drawable.overweight)
        } else if (myBMI >= 29.9) {
            bmi_image_view.setImageResource(R.drawable.obesity)
        }
    }
}