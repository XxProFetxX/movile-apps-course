package com.example.app_sem04_s1_2

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var questions: ArrayList<Question>
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setupViews()
    }

    private fun loadQuestions() {
        questions = ArrayList()
        var question = Question("¿Es Lima capital del Perú?", true)
        questions.add(question)
        questions.add(Question("¿Es Lima capital del Chile?", false))
        questions.add(Question("¿Es Lima una pelota?", false))
        questions.add(Question("¿Es Argentina de Messi?", true))
        questions.add(Question("¿Es Bogota Capital de Colombia?", true))
    }

    private fun setupViews() {
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val btNext = findViewById<Button>(R.id.btNext)

        tvQuestion.text = questions[position].sentence

        val btTrue = findViewById<Button>(R.id.btTrue)
        btTrue.setOnClickListener {
            checkQuestion(questions[position], true)
        }

        val btFalse = findViewById<Button>(R.id.btFalse)
        btFalse.setOnClickListener {
            checkQuestion(questions[position], false)
        }

        btNext.setOnClickListener {
            position++
            if (position < questions.size)
            tvQuestion.text = questions[position].sentence
        }
    }

    private fun checkQuestion(question: Question, btnValue: Boolean) {
        if (question.answer == btnValue) Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        else Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }
}