package cu.gd.mic.principal_activity


import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import cu.gd.mic.adapters.SectionPageAdapter
import cu.gd.mic.fragments.sections_fragments.FileFragment
import cu.gd.mic.fragments.sections_fragments.LectionsFragment
import cu.gd.mic.fragments.sections_fragments.ProfileFragment
import cu.gd.mic.fragments.sections_fragments.StadisticFragment
import android.graphics.PorterDuff
import android.os.Build
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.activeandroid.query.Select
import com.google.android.material.snackbar.Snackbar
import cu.gd.mic.R
import cu.gd.mic.model.Capitulo
import cu.gd.mic.model.Leccion


class PrincipalMenuActivity : AppCompatActivity() {
    private lateinit var tabLayout:TabLayout
    private lateinit var vpSections:ViewPager
    private lateinit var imageBtn: ImageButton
    private lateinit var tvPuntuacion:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_menu)
        tabLayout = findViewById(R.id.tl_menu)
        vpSections = findViewById(R.id.vp_sections)
        imageBtn=findViewById(R.id.configurationBtn)
        tvPuntuacion = findViewById(R.id.tv_puntuation)
        showPuntation()
        setUpSectionViewPager()

        tabLayout.setOnTabSelectedListener(object :
            TabLayout.ViewPagerOnTabSelectedListener(vpSections) {
            override fun onTabSelected(tab: TabLayout.Tab) {
                super.onTabSelected(tab)
                val tabIconColor = ContextCompat.getColor(this@PrincipalMenuActivity, R.color.colorAccent)
                tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                super.onTabUnselected(tab)
                val tabIconColor = ContextCompat.getColor(this@PrincipalMenuActivity, R.color.colorTabMenuIcon)
                tab!!.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                super.onTabReselected(tab)
            }
        })
    }
    private fun addFragmentsSections():List<Fragment>{
        var fragmentSections = mutableListOf<Fragment>()
        fragmentSections.add(LectionsFragment())
        fragmentSections.add(StadisticFragment())
        fragmentSections.add(FileFragment())
        fragmentSections.add(ProfileFragment())
        return fragmentSections
    }
    private fun setUpSectionViewPager(){
        vpSections.adapter = SectionPageAdapter(addFragmentsSections(),supportFragmentManager)
        tabLayout.setupWithViewPager(vpSections)
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_school_black_24dp)
        tabLayout.getTabAt(0)!!.text = getString(R.string.lecciones)
        val tabIconColor = ContextCompat.getColor(this@PrincipalMenuActivity, R.color.colorAccent)
        tabLayout.getTabAt(0)!!.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_assessment_black_24dp)
        tabLayout.getTabAt(1)!!.text = getString(R.string.estadisticas)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_book_black_24dp)
        tabLayout.getTabAt(2)!!.text = getString(R.string.libros)
        tabLayout.getTabAt(3)!!.setIcon(R.drawable.ic_face_black_24dp)
        tabLayout.getTabAt(3)!!.text = getString(R.string.perfil)

    }
    fun openConfiguration(v:View){
        val intent = Intent(this, ConfigurationActivity::class.java)
        startActivity(intent)

    }

    fun showPuntation(){
        val preferences = getSharedPreferences("Results",Context.MODE_PRIVATE)
        val corrects = preferences.getInt("corrects",0)
        val incorrects = preferences.getInt("incorrects",0)
        tvPuntuacion.text = (corrects-incorrects).toString()
    }


    override fun onResume() {
        super.onResume()
        showPuntation()
        if (Build.VERSION.SDK_INT >= 23) {
            val hw = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            if (hw != PackageManager.PERMISSION_GRANTED) {
                var array = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                requestPermissions(array,205)
            }
        }
    }
}
