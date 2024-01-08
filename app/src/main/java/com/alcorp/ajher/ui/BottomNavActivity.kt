package com.alcorp.ajher.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.ActivityBottomNavBinding
import com.alcorp.ajher.ui.quiz.create.QuizCategoryActivity

class BottomNavActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false

        binding.fab.setOnClickListener {
            startActivity(Intent(this, QuizCategoryActivity::class.java))
        }

        val navController = findNavController(R.id.nav_host_fragment_activity_bottom_nav)
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}