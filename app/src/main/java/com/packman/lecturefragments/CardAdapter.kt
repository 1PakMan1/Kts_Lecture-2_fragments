package com.packman.lecturefragments

import androidx.cardview.widget.CardView

interface CardAdapter {
    val itemCount: Int
    fun getCardAt(position: Int): CardView?

    companion object {
        const val MAX_ELEVATION_FACTOR = 5
        const val SCALE_FACTOR = 0.2f
        const val BASE_ELEVATION = 4
    }
}