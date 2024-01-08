package com.alcorp.ajher.ui.quiz.create

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.ActivityCreateQuizBinding
import com.alcorp.ajher.utils.Helper
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.CornerSize
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class CreateQuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        setToolbar()
        setCardView()

        binding.btnAddQuestion.setOnClickListener {
            binding.createQuizInformation.root.visibility = GONE
            binding.createQuizAnswer.root.visibility = VISIBLE
        }

        binding.ivSave.setOnClickListener {
            startActivity(Intent(this, ConfirmCreateQuizActivity::class.java))
        }
    }

    private fun setToolbar() {
        setSupportActionBar(binding.customToolbar.toolbar)
        binding.customToolbar.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.primary))
        binding.customToolbar.toolbar.setNavigationIconTint(ContextCompat.getColor(this, R.color.white))
        binding.customToolbar.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white))
        Helper.setToolbar(supportActionBar!!, getString(R.string.title_create_quiz))
    }

    private fun setCardView() {
        val leftShapePathModel = ShapeAppearanceModel().toBuilder()
        leftShapePathModel.setTopLeftCorner(
            CornerFamily.ROUNDED,
            CornerSize { return@CornerSize 40F })

        leftShapePathModel.setTopRightCorner(
            CornerFamily.ROUNDED,
            CornerSize { return@CornerSize 40F })

        val bg = MaterialShapeDrawable(leftShapePathModel.build())
        bg.fillColor = ColorStateList.valueOf(
            resources.getColor(android.R.color.white)
        )
        bg.elevation = 8F

        binding.cardView.background = bg
        binding.cardView.invalidate()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}