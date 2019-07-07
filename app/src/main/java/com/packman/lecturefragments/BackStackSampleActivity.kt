package com.packman.lecturefragments

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class BackStackSampleActivity : AppCompatActivity() {
    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, BackStackSampleActivity::class.java)
        }
    }
}