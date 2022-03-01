package cu.gd.mic.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SectionPageAdapter(
    private val sectionsFragments:List<Fragment>,
    fm: FragmentManager) :FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return sectionsFragments[position]
    }

    override fun getCount(): Int {
       return sectionsFragments.size
    }
}