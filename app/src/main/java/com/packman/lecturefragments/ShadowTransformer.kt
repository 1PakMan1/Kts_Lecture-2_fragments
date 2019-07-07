package com.packman.lecturefragments

import android.view.View
import androidx.viewpager.widget.ViewPager
import com.packman.lecturefragments.CardAdapter.Companion.BASE_ELEVATION
import com.packman.lecturefragments.CardAdapter.Companion.MAX_ELEVATION_FACTOR
import com.packman.lecturefragments.CardAdapter.Companion.SCALE_FACTOR

class ShadowTransformer(
    private val cardAdapter: CardAdapter,
    viewPager: ViewPager
) : ViewPager.OnPageChangeListener,
    ViewPager.PageTransformer {

    init {
        viewPager.setOnPageChangeListener(this)
    }

    private var lastOffset: Float = 0f

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        val goingLeft = lastOffset > positionOffset
        val baseElevation = BASE_ELEVATION

        val currentPosition: Int
        val nextPosition: Int
        val realOffset: Float

        if (goingLeft) {
            currentPosition = position + 1
            nextPosition = position
            realOffset = 1 - positionOffset
        } else {
            currentPosition = position
            nextPosition = position + 1
            realOffset = positionOffset
        }

        if (currentPosition > cardAdapter.itemCount - 1 || nextPosition > cardAdapter.itemCount - 1) return

        val currentCard = cardAdapter.getCardAt(currentPosition)
        val nextCard = cardAdapter.getCardAt(nextPosition)

        currentCard?.apply {
            scaleX = 1 + SCALE_FACTOR * (1 - realOffset)
            scaleY = 1 + SCALE_FACTOR * (1 - realOffset)
            elevation = baseElevation + baseElevation * MAX_ELEVATION_FACTOR * (1 - realOffset)
        }

        nextCard?.apply {
            scaleX = 1 + SCALE_FACTOR * (realOffset)
            scaleY = 1 + SCALE_FACTOR * (realOffset)
            elevation = baseElevation + baseElevation * MAX_ELEVATION_FACTOR * (realOffset)
        }

        lastOffset = positionOffset
    }

    override fun onPageScrollStateChanged(state: Int) {}
    override fun onPageSelected(position: Int) {}
    override fun transformPage(page: View, position: Float) {}
}