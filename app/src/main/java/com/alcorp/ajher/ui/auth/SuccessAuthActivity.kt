package com.alcorp.ajher.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.ActivitySuccessAuthBinding
import com.alcorp.ajher.ui.MainActivity

class SuccessAuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menu = intent.extras?.getString("menu")
        if (menu == "create") {
            binding.tvTitle.text = getString(R.string.txt_created_an_account)
            binding.tvDescription.text = getString(R.string.txt_your_account_has_been_created)
        } else {
            binding.tvTitle.text = getString(R.string.txt_chaned_the_password)
            binding.tvDescription.text = getString(R.string.txt_login_to_your_account)

        }

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
