package com.alcorp.ajher.ui.quiz.create

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.ActivityConfirmCreateQuizBinding
import com.alcorp.ajher.utils.Helper

class ConfirmCreateQuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmCreateQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmCreateQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        setToolbar()

        binding.btnConfirmQuiz.setOnClickListener {
            startActivity(Intent(this, SuccessQuizActivity::class.java))
        }
    }

    private fun setToolbar() {
        setSupportActionBar(binding.customToolbar.toolbar)
        binding.customToolbar.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.primary))
        binding.customToolbar.toolbar.setNavigationIconTint(ContextCompat.getColor(this, R.color.white))
        binding.customToolbar.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white))
        Helper.setToolbar(supportActionBar!!, getString(R.string.txt_confirm_quiz))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}