package com.example.convenientplanner

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_newtask.*
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.ContentValues
import android.icu.util.Calendar
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.Toast

class Newtask : AppCompatActivity() {
    companion object {
        val intentDataKey = "No tasks"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newtask)

        var localDB = TaskDB(this)

        button_add.setOnClickListener{
            var tempTask = editText.text.toString()

            var values = ContentValues()
            values.put(TaskDB.tasks, tempTask)

            localDB.addTask(values)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button_tocalendar4.setOnClickListener {
            val intent = Intent(this, com.example.convenientplanner.Calendar::class.java)
            startActivity(intent)
        }

        button_tosettings4.setOnClickListener {
            val intent = Intent(this, OptionsActivity::class.java)
            startActivity(intent)
        }

        button_add.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(intentDataKey, editText.getText().toString())
            startActivity(intent)
            Toast.makeText(this, """New task created""", Toast.LENGTH_LONG).show()

        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDataPicker(view: View) {
        val c = Calendar.getInstance()
        val cyear = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            choose_date.setText("""$dayOfMonth.${monthOfYear + 1}.$year""")

        }, cyear, month, day)
        dpd.show()
    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun clickTimePicker(view: View) {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR)
        val minute = c.get(Calendar.MINUTE)

        val tpd = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener(function = { view, h, m ->
            starts_at.setText(h.toString() + ":" + m)

        }),hour,minute,false)

        tpd.show()

    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun clickTimePicker2(view: View) {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR)
        val minute = c.get(Calendar.MINUTE)

        val tpd = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener(function = { view, h, m ->

            ends_at.setText(h.toString() + ":" + m)

        }),hour,minute,false)

        tpd.show()

    }

}