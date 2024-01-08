package com.alcorp.ajher.ui.quiz.play

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.alcorp.ajher.databinding.ActivityCorrectingQuizBinding

class CorrectingQuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCorrectingQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCorrectingQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        setupToolbar()
        setDelay()
    }

    private fun setupToolbar() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setDelay() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, QuizCompleteActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}