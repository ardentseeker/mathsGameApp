package com.example.mathgametest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class SubtractionGame : AppCompatActivity() {


    lateinit var score : TextView
    lateinit var life: TextView
    lateinit var time: TextView
    lateinit var ques:TextView
    lateinit var ok: Button
    lateinit var next:Button
    lateinit var input: EditText

    private var scoreV = 0
    private var lifeV = 3
    private var correctAns = 0
    private val totalTime = 60


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subtraction_game)

        score = findViewById(R.id.scoreVS)
        life = findViewById(R.id.lifeVS)
        time = findViewById(R.id.maxTS)
        input = findViewById(R.id.sAns)
        ok = findViewById(R.id.buttonS)
        next = findViewById(R.id.nextS)
        ques = findViewById(R.id.queS)

        subGameContinue()

        object :CountDownTimer(60000,100){
            override fun onTick(millisUntilFinished: Long) {
                time.text = (millisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                time.text = totalTime.toString()
                Toast.makeText(applicationContext,"your time is up ",Toast.LENGTH_LONG).show()
                subGameContinue()
            }

        }

        next.setOnClickListener {
            subGameContinue()
        }
        ok.setOnClickListener {

            val finalInp = input.text.toString()

            if (finalInp == "")
            {
                ques.setText("enter your answer first")
            }
            else
            {
                val userAns = finalInp.toInt()

                if (userAns == correctAns) {
                    ques.setText("Congratulation")
                    scoreV += 10
                    score.setText(scoreV)
                } else {
                    input.setText("")
                    lifeV--
                    life.setText(lifeV.toString())
                    Toast.makeText(applicationContext, "Wrong answer", Toast.LENGTH_LONG).show()
                }
                if (lifeV == 0) {
                    ques.setText("better luck next time")
                }
            }


        }
    }



    private fun subGameContinue(){
        val x = Random.nextInt(1000,40)
        val y = Random.nextInt(1000,40)
        ques.text = "$x - $y"
        correctAns = x - y
    }
}