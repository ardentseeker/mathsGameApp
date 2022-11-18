package com.example.mathgametest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var addition :Button
    lateinit var subtraction :Button
    lateinit var multiplication :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addition = findViewById(R.id.button)
        subtraction = findViewById(R.id.button2)
        multiplication = findViewById(R.id.button3)

        addition.setOnClickListener {
            val i =  Intent(applicationContext,AdditionGame::class.java)
            startActivity(i)
        }

        subtraction.setOnClickListener {
            val i = Intent(applicationContext,SubtractionGame::class.java)
            startActivity(i)
        }

        multiplication.setOnClickListener {
            val i = Intent(applicationContext,MultiplicationGame::class.java)
            startActivity(i)
        }

    }
}