package com.alcorp.ajher.ui.profile

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alcorp.ajher.databinding.FragmentProfileBinding
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.CornerSize
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var chartArrayList: ArrayList<Entry>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val dashboardViewModel =
//            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        init()

        return binding.root
    }

    private fun init() {
        setChart()
        setCardView()

        binding.ivSetting.setOnClickListener {
            startActivity(Intent(requireContext(), SettingsActivity::class.java))
        }
    }

    private fun setChart() {
        setChartData()
        val dataSet = LineDataSet(chartArrayList, "Chart")
        val barData = LineData(dataSet)

        dataSet.setColors(Color.WHITE)
        dataSet.valueTextColor = Color.WHITE
        dataSet.valueTextSize = 16f

        binding.lineChart.data = barData
    }

    private fun setChartData() {
        chartArrayList = ArrayList()
        for (i in 1..10) {
            val fl = i*10f
            chartArrayList.add(Entry(i.toFloat(), fl))
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}