package com.example.convenientplanner

import android.content.Intent
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_options.*
import android.support.v4.content.ContextCompat
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable



class OptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

            back_from_options.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button_tocalendar5.setOnClickListener {
            val intent = Intent(this, Calendar::class.java)

            bg4.setOnClickListener {
                val intent = Intent(this, Doki::class.java)
                startActivity(intent)
            }
        }
    }
}

