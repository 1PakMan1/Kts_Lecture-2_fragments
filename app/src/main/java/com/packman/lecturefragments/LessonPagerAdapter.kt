package com.packman.lecturefragments

import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class LessonPagerAdapter(
    fragmentManager: FragmentManager,
    lessons: List<LessonFragment>
) : FragmentStatePagerAdapter(fragmentManager),
    CardAdapter {

    private var fragments: MutableList<LessonFragment> = mutableListOf()

    init {
        fragments.addAll(lessons)
    }

    override val itemCount: Int = lessons.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return super.instantiateItem(container, position).also {
            fragments[position] = it as LessonFragment
        }
    }

    override fun getCardAt(position: Int): CardView? = fragments[position].getCard()

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int = fragments.size
}