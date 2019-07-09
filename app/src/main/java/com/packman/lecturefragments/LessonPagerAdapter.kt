package com.packman.lecturefragments

import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class LessonPagerAdapter(
    private val getLesson: (Int) -> LessonFragment,
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager),
    CardAdapter {

    private var fragmentTags = mutableMapOf<Int, LessonFragment>()

    override val itemCount: Int = NUM_OF_ITEMS

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return super.instantiateItem(container, position).also {
            fragmentTags[position] = (it as LessonFragment)
        }
    }

    override fun getCardAt(position: Int): CardView? {
        return fragmentTags[position]?.getCard()
    }

    override fun getItem(position: Int): Fragment {
        return getLesson(position)
    }

    override fun getCount(): Int = NUM_OF_ITEMS

    companion object {
        private const val NUM_OF_ITEMS = 6
    }
}