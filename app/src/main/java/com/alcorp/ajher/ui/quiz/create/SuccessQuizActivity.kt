package com.alcorp.ajher.ui.quiz.create

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alcorp.ajher.databinding.ActivitySuccessQuizBinding
import com.alcorp.ajher.ui.quiz.detail.DetailQuizActivity

class SuccessQuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDetail.setOnClickListener {
            val intent = Intent(this, DetailQuizActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}