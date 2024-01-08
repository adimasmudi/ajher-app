package com.alcorp.ajher.ui.quiz.detail

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.ActivityDetailQuizBinding
import com.alcorp.ajher.ui.quiz.play.PlayQuizActivity
import com.alcorp.ajher.utils.Helper

class DetailQuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        setToolbar()
        binding.btnPlay.setOnClickListener {
            showDialog()
        }
    }

    private fun setToolbar() {
        setSupportActionBar(binding.customToolbar.toolbar)
        binding.customToolbar.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.primary))
        binding.customToolbar.toolbar.setNavigationIconTint(ContextCompat.getColor(this, R.color.white))
        Helper.setToolbar(supportActionBar!!, "")

    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this,R.style.CustomAlertDialog)
            .create()
        builder.setCancelable(false)
        val view = layoutInflater.inflate(R.layout.dialog_play_quiz,null)

        val btnPlay = view.findViewById(R.id.btnPlay) as Button
        btnPlay.setOnClickListener {
            startActivity(Intent(this, PlayQuizActivity::class.java))
        }

        val btnCancel = view.findViewById(R.id.btnCancel) as Button
        btnCancel.setOnClickListener {
            builder.dismiss()
        }

        builder.setView(view)
        builder.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}