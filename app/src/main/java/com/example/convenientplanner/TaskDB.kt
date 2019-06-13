package com.example.convenientplanner

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder
import android.service.autofill.UserData

class TaskDB(context: Context) : SQLiteOpenHelper(context, DBName, null, DBVersion) {
    companion object {
        val DBName = "TasksDB" // Название БД
        val DBVersion = 1 // Версия БД
        val tableName = "taskTable" // Название таблицы
        val tasks = "tsk"
    }
    var sqlObj: SQLiteDatabase = this.writableDatabase
    override fun onCreate(p0: SQLiteDatabase?) {
        var sql1: String = "CREATE TABLE IF NOT EXISTS $tableName (  $tasks TEXT );"
        p0!!.execSQL(sql1);
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) { // Вызывается при обновлении версии БД
        p0!!.execSQL("Drop table IF EXISTS $tableName")
        onCreate(p0)
    }
    fun addTask(values: ContentValues) = sqlObj.insert(tableName, "", values)

    fun listTasks(key : String) : ArrayList<Model> {
        var arraylist = ArrayList<Model>()
        var sqlQB = SQLiteQueryBuilder()
        sqlQB.tables = tableName
        var cols = arrayOf(tasks)
        var selectArgs = arrayOf(key)
        //sqlObj.rawQuery("")
        var cursor = sqlQB.query(sqlObj, cols,"$tasks like ?", selectArgs,null,null, tasks)

        if (cursor.moveToFirst()) {
            do {

                val newtsk = cursor.getString(cursor.getColumnIndex(tasks))


                arraylist.add(Model(newtsk))

            } while (cursor.moveToNext())
        }
        return arraylist
    }

}