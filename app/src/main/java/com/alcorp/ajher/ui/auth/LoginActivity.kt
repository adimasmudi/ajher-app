package com.alcorp.ajher.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.ActivityLoginBinding
import com.alcorp.ajher.ui.BottomNavActivity
import com.alcorp.ajher.utils.Helper.setToolbar

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.customToolbar.toolbar)
        setToolbar(supportActionBar!!, getString(R.string.txt_login))

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, BottomNavActivity::class.java))
        }

        binding.tvForgotPass.setOnClickListener {
            startActivity(Intent(this, ResetPasswordActivity::class.java))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}