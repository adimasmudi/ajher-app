package com.alcorp.ajher.ui.quiz.play

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alcorp.ajher.databinding.ActivityQuizCompleteBinding
import com.alcorp.ajher.ui.history.review_answer.ReviewAnswerActivity

class QuizCompleteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizCompleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizCompleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvCheckAnswer.setOnClickListener {
            val intent = Intent(this, ReviewAnswerActivity::class.java)
            startActivity(intent)
        }

        binding.btnDone.setOnClickListener {
            val intent = Intent(this, QuizLeaderboardActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}