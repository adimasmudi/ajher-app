package com.alcorp.ajher.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.ActivityResetPasswordBinding
import com.alcorp.ajher.utils.Helper

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.customToolbar.toolbar)
        Helper.setToolbar(supportActionBar!!, getString(R.string.txt_reset_password))

        binding.btnContinue.setOnClickListener {
            val intent = Intent(this, OtpVerificationActivity::class.java)
            intent.putExtra("menu", "reset")
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}