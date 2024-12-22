package com.example.peoplelistk

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val peopleList = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val personListView: ListView = findViewById(R.id.personListView)
        val addButton: Button = findViewById(R.id.addButton)
        adapter = ArrayAdapter(this, R.layout.item, R.id.firstNameTextView, peopleList)
        personListView.adapter = adapter
        addButton.setOnClickListener { addRandomPerson() }
    }

    private fun addRandomPerson() {
        val firstNames = resources.getStringArray(R.array.first_names)
        val lastNames = resources.getStringArray(R.array.last_names)
        val person = "${firstNames.random()} ${lastNames.random()}"
        peopleList.add(person)
        adapter.notifyDataSetChanged()
        Toast.makeText(this, "Добавлен: $person", Toast.LENGTH_SHORT).show()
    }
}
