package com.packman.lecturefragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerSampleActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_view_pager)

        with(pager) {
            adapter = cardAdapter
            setPageTransformer(
                false,
                ShadowTransformer(cardAdapter as CardAdapter, this)
            )
        }
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, ViewPagerSampleActivity::class.java)
        }
    }
}