package com.example.lab1

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //khai báo
    var colors = arrayOf("", "", "")
    var myAdapter: ArrayAdapter<String>? = null
    var listView: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById<ListView>(R.id.listView)
        myAdapter = object :
            ArrayAdapter<String?>(this@MainActivity, android.R.layout.simple_list_item_1, colors) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                if (position == 0) {
                    view.setBackgroundColor(-0xcd00)
                }
                if (position == 1) {
                    view.setBackgroundColor(-0x9a)
                }
                if (position == 2) {
                    view.setBackgroundColor(-0xff7800)
                }
                return view
            }
        }
        listView.setAdapter(myAdapter)
    }
}