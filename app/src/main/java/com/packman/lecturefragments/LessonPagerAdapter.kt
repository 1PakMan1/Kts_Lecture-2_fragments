package com.packman.lecturefragments

import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class LessonPagerAdapter(
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager),
    CardAdapter {

    private val lessons = listOf(
        LessonFragment.getInstance(true, "Android Studio"),
        LessonFragment.getInstance(true, "Gradle"),
        LessonFragment.getInstance(true, "Layers"),
        LessonFragment.getInstance(false, "View (xml)"),
        LessonFragment.getInstance(false, "Resources"),
        LessonFragment.getInstance(false, "Activity")
    )

    override val itemCount: Int = lessons.size

    override fun getCardAt(position: Int): CardView? = lessons[position].getCard()

    override fun getItem(position: Int): Fragment {
        return lessons[position]
    }

    override fun getCount(): Int = lessons.size
}