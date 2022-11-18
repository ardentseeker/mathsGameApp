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

class AdditionGame : AppCompatActivity() {

    lateinit var score :TextView
    lateinit var life:TextView
    lateinit var time:TextView
    lateinit var ques:TextView
    lateinit var ok:Button
    lateinit var next:Button
    lateinit var input:EditText

    private var scoreV = 0
    private var lifeV = 3
    private var correctAns = 0
    val totalTime = 60


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addition_game)

        score = findViewById(R.id.scoreVA)
        life = findViewById(R.id.lifeVA)
        time = findViewById(R.id.maxTA)
        ques = findViewById(R.id.queA)
        input = findViewById(R.id.ansA)
        ok = findViewById(R.id.buttonA)
        next = findViewById(R.id.nextA)

        addGameContinue()


        ok.setOnClickListener {


            val finalInp = input.text.toString()
            if(finalInp == "" )
            {
                Toast.makeText(applicationContext,"enter your answer first",Toast.LENGTH_LONG).show()
            }
            else
            {
                val userAns = finalInp.toInt()

                if (userAns == correctAns){
                    ques.setText("Congratulation")
                    scoreV += 10
                    score.setText(scoreV)
                }
                else
                {
                    input.setText("")
                    lifeV--
                    life.setText(lifeV.toString())
                    Toast.makeText(applicationContext,"Wrong answer",Toast.LENGTH_LONG).show()
                }
                if (lifeV == 0){
                    ques.setText("better luck next time")
                }
            }

        }
        next.setOnClickListener {
            addGameContinue()
            input.setText("")
        }

    }

   private fun addGameContinue(){

       object : CountDownTimer(60000, 1000) {

           override fun onTick(millisUntilFinished: Long) {
               time.text = (millisUntilFinished / 1000).toString()
           }

           override fun onFinish() {
               time.text = totalTime.toString()
               Toast.makeText(applicationContext,"your time is up ",Toast.LENGTH_LONG).show()
               addGameContinue()
           }
       }.start()
        val x = Random.nextInt(199,1000)
        val y = Random.nextInt(199,1000)
        ques.text = "$x + $y "
        correctAns = x + y

    }


}