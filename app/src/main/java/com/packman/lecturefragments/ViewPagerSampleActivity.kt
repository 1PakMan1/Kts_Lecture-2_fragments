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
        if (savedInstanceState == null) startNavigation()
    }

    override fun onTopicSelected(topic: String) = openDetailedScreen(topic)

    private fun startNavigation() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, ViewPagerFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun openDetailedScreen(topic: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, InfoFragment())
            .addToBackStack(null)
            .commit()
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, ViewPagerSampleActivity::class.java)
        }
    }
}