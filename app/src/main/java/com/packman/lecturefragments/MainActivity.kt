package com.packman.lecturefragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val lessons = listOf(
        LessonFragment.getInstance(true, "Android Studio"),
        LessonFragment.getInstance(true, "Gradle"),
        LessonFragment.getInstance(true, "Layers"),
        LessonFragment.getInstance(false, "View (xml)"),
        LessonFragment.getInstance(false, "Resources"),
        LessonFragment.getInstance(false, "Activity")
    )

    private val cardAdapter = LessonPagerAdapter(
        fragmentManager = supportFragmentManager,
        lessons = lessons
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(pager) {
            adapter = cardAdapter
            setPageTransformer(
                false,
                ShadowTransformer(cardAdapter as CardAdapter, this)
            )
        }
    }
}
