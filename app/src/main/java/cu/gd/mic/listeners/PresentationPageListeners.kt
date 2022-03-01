package cu.gd.mic.listeners

import androidx.viewpager.widget.ViewPager

class PresentationPageListeners:ViewPager.SimpleOnPageChangeListener() {
    private var currentPage = 0
    override fun onPageSelected(position: Int) {
        currentPage = position
    }
    fun getCurrentPage():Int = currentPage
}