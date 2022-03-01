package cu.gd.mic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import cu.gd.mic.adapters.PresentationPageAdapter
import cu.gd.mic.fragments.presentation_fragments.FirstPresentationPage
import cu.gd.mic.fragments.presentation_fragments.SecondPresentationPage
import cu.gd.mic.fragments.presentation_fragments.ThirdPresentationPage
import cu.gd.mic.principal_activity.PrincipalMenuActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var vpPresent:ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vpPresent = findViewById(R.id.vp_content)
        val fragments = mutableListOf<Fragment>()
        fragments.add(FirstPresentationPage())
        fragments.add(SecondPresentationPage())
        fragments.add(ThirdPresentationPage())
        val ppAdapter =
            PresentationPageAdapter(fragments, supportFragmentManager)
        vpPresent.adapter = ppAdapter
        vpPresent.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> progress.setImageResource(R.drawable.progeso_1)
                    1 -> progress.setImageResource(R.drawable.progeso)
                    else -> progress.setImageResource(R.drawable.progeso_3)
                }
            }

        })
    }
    fun changePage(v: View){
        if (vpPresent.currentItem<2) {
            vpPresent.currentItem++
        }else {
            openPrincipal(null)
        }
    }
    fun openPrincipal(v:View?){
        var intent = Intent(this, PrincipalMenuActivity::class.java)
        startActivity(intent)
    }

}
