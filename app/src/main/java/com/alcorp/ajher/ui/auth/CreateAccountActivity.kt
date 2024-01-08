package com.alcorp.ajher.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.ActivityCreateAccountBinding
import com.alcorp.ajher.utils.Helper

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.customToolbar.toolbar)
        Helper.setToolbar(supportActionBar!!, getString(R.string.title_create_account))

        binding.btnCreateAccount.setOnClickListener {
            val intent = Intent(this, OtpVerificationActivity::class.java)
            intent.putExtra("menu", "create")
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}