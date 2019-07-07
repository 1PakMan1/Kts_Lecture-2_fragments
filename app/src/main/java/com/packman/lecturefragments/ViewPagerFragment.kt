package com.packman.lecturefragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_view_pager.*

class ViewPagerFragment : Fragment(), LessonFragment.LessonSelectionListener {

    private lateinit var cardAdapter: LessonPagerAdapter

    private var navigationListener: NavigationListener? = null

    private val lessons = listOf(
        LessonFragment.getInstance(true, "Android Studio"),
        LessonFragment.getInstance(true, "Gradle"),
        LessonFragment.getInstance(true, "Layers"),
        LessonFragment.getInstance(false, "View (xml)"),
        LessonFragment.getInstance(false, "Resources"),
        LessonFragment.getInstance(false, "Activity")
    )

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        navigationListener = activity as NavigationListener
    }

    override fun onDetach() {
        super.onDetach()
        navigationListener = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
    }

    override fun onLessonSelected(lesson: String) {
        navigationListener!!.onTopicSelected(lesson)
    }

    private fun initList() {
        cardAdapter = LessonPagerAdapter(
            fragmentManager = childFragmentManager,
            lessons = lessons
        )

        with(pager) {
            adapter = cardAdapter
            setPageTransformer(
                false,
                ShadowTransformer(cardAdapter as CardAdapter, this)
            )
        }
    }

    interface NavigationListener {
        fun onTopicSelected(topic: String)
    }
}