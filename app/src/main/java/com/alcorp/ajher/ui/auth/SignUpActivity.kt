package com.alcorp.ajher.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.ActivitySignUpBinding
import com.alcorp.ajher.utils.Helper

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.customToolbar.toolbar)
        Helper.setToolbar(supportActionBar!!, getString(R.string.title_sign_up))

        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this, CreateAccountActivity::class.java))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}