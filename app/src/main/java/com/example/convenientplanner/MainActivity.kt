package com.example.convenientplanner

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_daytask.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calend.setOnClickListener {
            val intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        }
        settings.setOnClickListener {
            val intent = Intent(this, OptionsActivity::class.java)
            startActivity(intent)
        }
        newtsk1.setOnClickListener {
            val intent = Intent(this, Newtask::class.java)
            startActivity(intent)
        }

    }
    override fun onResume() {
        super.onResume()
        var localDB = TaskDB(this)
        var tskDataList = localDB.listTasks("%")

        if(tskDataList.size >= 0) {
            var lazyData = ArrayList<String>()

            for (temp in tskDataList){
                lazyData.add(temp.task)
            }
            var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lazyData)
            tasklist.adapter = adapter
        }

       /* tasklist.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, Newtask::class.java)
            startActivity(intent)
        }*/

        newtsk1.setOnClickListener {
            val intent = Intent(this, Newtask::class.java)
            startActivity(intent)
        }
    }
}

