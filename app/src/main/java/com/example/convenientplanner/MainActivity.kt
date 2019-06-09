package com.example.convenientplanner

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        settings.setOnClickListener {
            val intent = Intent(this, OptionsActivity::class.java)
            startActivity(intent)
        }
        list.setOnClickListener {
            val intent = Intent(this, OptionsActivity::class.java)
            startActivity(intent)
        }
        newtsk.setOnClickListener {
            val intent = Intent(this, Newtask::class.java)
            startActivity(intent)
        }
        calend.setOnClickListener {
            val intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        }
        if (intent.hasExtra(Newtask.intentDataKey)){
            text_field.text = intent.getStringExtra(Newtask.intentDataKey)
        }


    }
}
