package com.alcorp.ajher.ui.history

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alcorp.ajher.databinding.FragmentHistoryBinding
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.CornerSize
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val notificationsViewModel =
//            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentHistoryBinding.inflate(inflater, container, false)

        setCardView()
        setPager()

        return binding.root
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
            requireContext().resources.getColor(android.R.color.white)
        )
        bg.elevation = 8F

        binding.cardView.background = bg
        binding.cardView.invalidate()
    }

    private fun setPager() {
        val quizPagerAdapter =
            QuizPagerAdapter(childFragmentManager, binding.tabLayout.tabCount, requireContext())
        binding.pager.adapter = quizPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.pager)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}