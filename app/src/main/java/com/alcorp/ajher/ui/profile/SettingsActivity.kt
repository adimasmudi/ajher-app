package com.alcorp.ajher.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.ActivitySettingsBinding
import com.alcorp.ajher.utils.Helper

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.customToolbar.toolbar)
        binding.customToolbar.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        Helper.setToolbar(supportActionBar!!, getString(R.string.title_settings))

        binding.cvFaq.setOnClickListener {
            val intent = Intent(this, HelpActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}