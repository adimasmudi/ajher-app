package com.alcorp.ajher.ui.history.quiz_created

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alcorp.ajher.databinding.ActivityParticipantListBinding
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.CornerSize
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class ParticipantListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityParticipantListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParticipantListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCardView()
    }

    private fun setCardView() {
        val leftShapePathModel = ShapeAppearanceModel().toBuilder()
        leftShapePathModel.setTopLeftCorner(
            CornerFamily.ROUNDED,
            CornerSize { return@CornerSize 20F })

        leftShapePathModel.setTopRightCorner(
            CornerFamily.ROUNDED,
            CornerSize { return@CornerSize 20F })

        val bg = MaterialShapeDrawable(leftShapePathModel.build())
        bg.fillColor = ColorStateList.valueOf(
            resources.getColor(android.R.color.white)
        )
        bg.elevation = 8F

        binding.cardView.background = bg
        binding.cardView.invalidate()
    }
}