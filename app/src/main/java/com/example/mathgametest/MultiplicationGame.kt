package com.example.mathgametest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.random.Random

class MultiplicationGame : AppCompatActivity() {


    private lateinit var score : TextView
    private lateinit var ok: Button
    lateinit var life: TextView
    lateinit var time: TextView
    lateinit var ques:TextView
    lateinit var next: Button
    lateinit var input: EditText


    private var scoreV = 0
    private var lifeV = 3
    private var correctAns = 0
    val totalTime = 60
    var remainingTime = 0


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplication_game)

        score = findViewById(R.id.scoreVM)
        life = findViewById(R.id.lifeVM)
        time = findViewById(R.id.maxTM)
        ques = findViewById(R.id.queM)
        input = findViewById(R.id.ansM)
        ok = findViewById(R.id.buttonM)
        next = findViewById(R.id.nextM)


        object :CountDownTimer(60000,1000){
            override fun onTick(millisUntilFinished: Long) {
                time.text = (millisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                Toast.makeText(applicationContext,"your time is up ",Toast.LENGTH_LONG).show()
                multiplicationGameContinue()
                time.text = "60"
            }

        }


        ok.setOnClickListener {

            val finalInp = input.text.toString()
            if (finalInp == "") {
                ques.setText("enter your answer first")
            } else {
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

    override fun onPause() {
        super.onPause()
        multiplicationGameContinue()

    }

    private fun multiplicationGameContinue(){
        val x = Random.nextInt(1000,40)
        val y = Random.nextInt(1000,40)
        ques.text = "$x * $y"
        correctAns = x * y
    }

}