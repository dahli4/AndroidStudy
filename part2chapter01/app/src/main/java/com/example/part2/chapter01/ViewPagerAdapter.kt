package com.example.part2.chapter01

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(private val mainActivity: MainActivity) :
    FragmentStateAdapter(mainActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> WebViewFragment()
            1 -> BFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}