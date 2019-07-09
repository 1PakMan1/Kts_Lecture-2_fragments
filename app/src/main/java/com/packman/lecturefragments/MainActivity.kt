package com.packman.lecturefragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showViewPager.setOnClickListener {
            startActivity(ViewPagerSampleActivity.getIntent(this))
        }

        showBackStackSamples.setOnClickListener {
            startActivity(BackStackSampleActivity.getIntent(this))
        }
    }
}
