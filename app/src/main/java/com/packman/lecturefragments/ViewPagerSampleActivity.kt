package com.packman.lecturefragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ViewPagerSampleActivity : AppCompatActivity(),
    ViewPagerFragment.NavigationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        startNavigation()
    }

    override fun onTopicSelected(topic: String) = openDetailedScreen(topic)

    private fun startNavigation() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, ViewPagerFragment())
            .commitNow()
    }

    private fun openDetailedScreen(topic: String) {

    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, ViewPagerSampleActivity::class.java)
        }
    }
}