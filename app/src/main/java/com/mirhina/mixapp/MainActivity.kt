package com.mirhina.mixapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var isDouble = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list_item = mutableListOf<ListViewModel>()

        list_item.add(ListViewModel("a","b"))
        list_item.add(ListViewModel("c","d"))
        list_item.add(ListViewModel("e","f"))

        val listview = findViewById<ListView>(R.id.mainListview)

        val listAdapter = ListViewAdapter(list_item)
        listview.adapter = listAdapter
    }

    override fun onBackPressed() {
        if(isDouble == true){
            finish()
        }

        isDouble = true
        Toast.makeText(this,"종료하시려면 뒤로가기를 한번 더 눌러주세요.",Toast.LENGTH_SHORT).show()
        Handler().postDelayed(
            {
                isDouble = false
            },2000
        )
    }
}