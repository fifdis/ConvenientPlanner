package com.example.convenientplanner

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calendar.*
import android.widget.Toast
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.view.View


class Calendar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_calendar)

        val calendarView = findViewById(R.id.calendarView) as CalendarView
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val selectedDate = StringBuilder().append(month + 1)
                .append("-").append(dayOfMonth).append("-").append(year)
                .append(" ").toString()
            Toast.makeText(applicationContext, selectedDate, Toast.LENGTH_SHORT).show()


             val intent = Intent(this, daytask::class.java)
            intent.putExtra("date", selectedDate)
            startActivity(intent)

        }


        back_from_calendar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        button_tosettings1.setOnClickListener {
            val intent = Intent(this, OptionsActivity::class.java)
            startActivity(intent)
        }
        newtsk2.setOnClickListener {
            val intent = Intent(this, Newtask::class.java)
            startActivity(intent)
        }


    }


}
