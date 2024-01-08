package com.alcorp.ajher.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alcorp.ajher.R
import com.alcorp.ajher.databinding.FragmentDashboardBinding
import com.alcorp.ajher.ui.quiz.detail.DetailQuizActivity


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val dashboardViewModel =
//            ViewModelProvider(this).get(DashboardViewModel::class.java)
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        init()

        return binding.root
    }

    private fun init() {
        setSpinner()
//        setRecycler()

        binding.btnJoin.setOnClickListener {
            startActivity(Intent(requireContext(), DetailQuizActivity::class.java))
        }

        binding.cvLeaderboard.setOnClickListener {
            startActivity(Intent(requireContext(), LeaderboardActivity::class.java))
        }
    }

    private fun setSpinner() {
        val data = activity!!.resources.getStringArray(R.array.played_categories)
        val spinnerArrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, data)
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spPlayed.adapter = spinnerArrayAdapter
    }

    private fun setRecycler() {
        val leaderboard = mutableListOf(Leaderboard())
        binding.rvLeaderboard.apply {
            adapter = LeaderboardAdapter(leaderboard)
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}