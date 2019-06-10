package com.example.convenientplanner

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_daytask.*
import kotlinx.android.synthetic.main.activity_daytask.button_back
import kotlinx.android.synthetic.main.activity_daytask.button_tocalendar2
import kotlinx.android.synthetic.main.activity_daytask.button_tosettings2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_newtask.*

class daytask : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daytask)

        button_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button_tocalendar2.setOnClickListener {
            val intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        }

        button_tosettings2.setOnClickListener {
            val intent = Intent(this, OptionsActivity::class.java)
            startActivity(intent)
        }


        newtsk3.setOnClickListener {
            val intent = Intent(this, Newtask::class.java)
            startActivity(intent)
        }

    }
}
