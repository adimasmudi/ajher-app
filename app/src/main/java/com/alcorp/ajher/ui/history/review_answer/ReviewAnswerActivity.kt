package com.alcorp.ajher.ui.history.review_answer

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.ActivityDetailQuizBinding
import com.alcorp.ajher.utils.Helper

class ReviewAnswerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        setToolbar()
    }

    private fun setToolbar() {
        setSupportActionBar(binding.customToolbar.toolbar)
        binding.customToolbar.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.primary))
        binding.customToolbar.toolbar.setNavigationIconTint(ContextCompat.getColor(this, R.color.white))
        Helper.setToolbar(supportActionBar!!, resources.getString(R.string.title_review_answer))

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}