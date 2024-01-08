package com.alcorp.ajher.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.ActivityOtpVerificationBinding
import com.alcorp.ajher.utils.Helper

class OtpVerificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOtpVerificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.customToolbar.toolbar)
        Helper.setToolbar(supportActionBar!!, getString(R.string.title_otp_verif))

        val menu = intent.extras?.getString("menu")
        if (menu == "create") {
            binding.btnContinue.setOnClickListener {
                val intent = Intent(this, SuccessAuthActivity::class.java)
                intent.putExtra("menu", "create")
                startActivity(intent)
            }
        } else {
            binding.btnContinue.setOnClickListener {
                startActivity(Intent(this, NewPasswordActivity::class.java))
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}