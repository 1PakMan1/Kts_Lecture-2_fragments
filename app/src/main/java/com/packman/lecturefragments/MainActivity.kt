package com.packman.lecturefragments

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager.adapter = LessonPagerAdapter(fragmentManager = supportFragmentManager)
        pager.pageMargin = getPxFromDp(PAGE_MARGIN)
    }

    companion object {
        private const val PAGE_MARGIN = 30
        internal fun Context.getPxFromDp(dpValue: Int): Int {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dpValue.toFloat(), resources.displayMetrics
            ).toInt()
        }
    }
}
