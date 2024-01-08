package com.alcorp.ajher.ui.history.quiz_joined

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alcorp.ajher.databinding.FragmentQuizJoinedBinding

class QuizJoinedFragment : Fragment() {

    private var _binding: FragmentQuizJoinedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuizJoinedBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}