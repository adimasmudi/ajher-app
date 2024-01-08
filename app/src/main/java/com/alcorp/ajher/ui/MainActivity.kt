package com.alcorp.ajher.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alcorp.ajher.databinding.ActivityMainBinding
import com.alcorp.ajher.ui.auth.LoginActivity
import com.alcorp.ajher.ui.auth.SignUpActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnCreateAccount.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}