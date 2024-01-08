package com.alcorp.ajher.ui.quiz.play

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.ActivityPlayQuizBinding
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.CornerSize
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class PlayQuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        setCardView()

        binding.cvLock.setOnClickListener {
            showLockDialog()
        }

        binding.btnNext.setOnClickListener {
            showCompleteDialog()
        }
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

    private fun showLockDialog() {
        val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)
            .create()
        builder.setCancelable(true)

        val view = layoutInflater.inflate(R.layout.dialog_locked,null)

        builder.setView(view)
        builder.show()
    }

    private fun showCompleteDialog() {
        val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)
            .create()
        builder.setCancelable(true)

        val view = layoutInflater.inflate(R.layout.dialog_complete_quiz,null)

        val btnDone = view.findViewById(R.id.btnSend) as Button
        btnDone.setOnClickListener {
            startActivity(Intent(this, CorrectingQuizActivity::class.java))
        }

        builder.setView(view)
        builder.show()
    }
}