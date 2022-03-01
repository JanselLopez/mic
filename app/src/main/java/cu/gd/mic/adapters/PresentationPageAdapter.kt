package cu.gd.mic.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import cu.gd.mic.R
import kotlinx.android.synthetic.main.activity_main.*
import cu.gd.mic.MainActivity
class PresentationPageAdapter(
    var fragments: List<Fragment>,
    fm: FragmentManager):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItemPosition(`object`: Any): Int {
        return super.getItemPosition(`object`)
    }
}