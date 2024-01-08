package com.alcorp.ajher.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.ActivityNewPasswordBinding
import com.alcorp.ajher.utils.Helper

class NewPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.customToolbar.toolbar)
        Helper.setToolbar(supportActionBar!!, getString(R.string.title_new_pass))

        binding.btnResetPass.setOnClickListener {
            val intent = Intent(this, SuccessAuthActivity::class.java)
            intent.putExtra("menu", "reset")
            startActivity(intent)
        }

//        if (binding.editTextPass.text.toString().toInt() < 8) {
//            binding.inputLayoutPass.error = getString(R.string.error_at_least_8_char)
//        } else {
//            binding.inputLayoutPass.error = ""
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}
