package com.example.mytodo6088130

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.SQLException

class ToDoDBAdapter(private val context: Context) {
    private var db:SQLiteDatabase? = null
    private val dbHelper: ToDoDBOpenHelper
    @Throws(SQLException::class)
    fun open()
    {
        db = try {
            dbHelper.writableDatabase
        } catch (ex: SQLException)
        {
            dbHelper.readableDatabase
        }
    }

    fun close()
    {
        db!!.close()
    }

    fun insertTask(task: String?): Long {
        val newTaskValues = ContentValues()
        newTaskValues.put(KEY_TASK,task)
        return db!!.insert(TABLE_NAME,null,newTaskValues)
    }

    fun selectAllToDoItems(): Cursor {
        return db!!.query(TABLE_NAME, arrayOf(KEY_ID, KEY_TASK),
                null, null, null, null, null)
    }


private class ToDoDBOpenHelper(context: Context?, name: String?,
                               factory: SQLiteDatabase.CursorFactory?, version: Int):
        SQLiteOpenHelper(context,name,factory,version) {

    override fun onCreate(db: SQLiteDatabase)
    {
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
    companion object {
        private const val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT, $KEY_TASK TEXT NOT NULL);"
    }
}
    companion object {
        private const val DATABASE_NAME = "ToDoList.db"
        private const val TABLE_NAME = "ToDoItem"
        private const val DATABASE_VERSION = 1
        const val KEY_ID = "id"
        const val KEY_TASK = "task"
    }

    init {
        dbHelper = ToDoDBOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION)
    }
}
