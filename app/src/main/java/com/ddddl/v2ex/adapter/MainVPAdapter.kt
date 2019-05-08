package com.ddddl.v2ex.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ddddl.v2ex.fragment.NodeListFragment
import com.ddddl.v2ex.fragment.TopicsFragment

class MainVPAdapter(fm: FragmentManager) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                TopicsFragment.newInstance()
            }
            1 -> {
                NodeListFragment.newInstance()
            }
            else -> {
                NodeListFragment.newInstance()
            }
        }
    }

}