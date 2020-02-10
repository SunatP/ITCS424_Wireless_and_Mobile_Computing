package com.example.mytodo6088130

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private var editText: EditText? = null
    private var listView: ListView? = null
    private var todoItems: ArrayList<String>? = null
    private var aa: ArrayAdapter<String>? = null
    private var toDoDBAdapter: ToDoDBAdapter? = null
    private var cursor: Cursor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editText)
        listView = findViewById(R.id.Listview)
        todoItems = ArrayList()
        aa = ArrayAdapter(this,android.R.layout.simple_list_item_1, todoItems!!)
        listView!!.adapter = this.aa

        editText!!.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)
            {
                val toDoItem = editText!!.text.toString()
                editText!!.setText("")
                toDoDBAdapter!!.insertTask(toDoItem)
                updateArray()
                return@setOnKeyListener true
            }
            false
        }
        toDoDBAdapter = ToDoDBAdapter(this)
        toDoDBAdapter!!.open()
        populateToDoList()
    }
    private fun populateToDoList()
    {
        cursor = toDoDBAdapter!!.selectAllToDoItems()
        updateArray()
    }

    private fun updateArray() {
        cursor!!.requery()
        todoItems!!.clear()
        if (cursor!!.moveToFirst())
        {
            do {
                val task = cursor!!.getString(cursor!!.getColumnIndex(ToDoDBAdapter.KEY_TASK))
                todoItems!!.add(0,task)

            } while (cursor!!.moveToNext())
        }
        aa!!.notifyDataSetChanged()
    }
}