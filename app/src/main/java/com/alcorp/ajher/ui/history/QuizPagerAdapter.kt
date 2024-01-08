package com.alcorp.ajher.ui.history

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.alcorp.ajher.R
import com.alcorp.ajher.ui.history.quiz_created.QuizCreatedFragment
import com.alcorp.ajher.ui.history.quiz_joined.QuizJoinedFragment

class QuizPagerAdapter(fm: FragmentManager, private val numberTabs: Int, private val context: Context) :
    FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> QuizJoinedFragment()
            1 -> QuizCreatedFragment()
            else -> QuizJoinedFragment()
        }
    }

    override fun getCount(): Int {
        return numberTabs
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return context.getString(R.string.txt_quiz_joined)
            }
            1 -> {
                return context.getString(R.string.txt_quiz_created)
            }
        }
        return super.getPageTitle(position)
    }
}
