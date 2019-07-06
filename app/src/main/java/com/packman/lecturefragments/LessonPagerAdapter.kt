package com.packman.lecturefragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class LessonPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val lessons = listOf(
        LessonFragment.getInstance(true, "Android Studio"),
        LessonFragment.getInstance(true, "Gradle"),
        LessonFragment.getInstance(true, "Layers"),
        LessonFragment.getInstance(false, "View (xml)"),
        LessonFragment.getInstance(false, "Resources"),
        LessonFragment.getInstance(false, "Activity")
    )

    override fun getItem(position: Int): Fragment {
        return lessons[position]
    }

    override fun getCount(): Int {
        return lessons.size
    }
}