package cu.gd.mic.fragments.sections_fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import cu.gd.mic.R
import cu.gd.mic.adapters.LectionAdapter
import cu.gd.mic.model.Leccion
import cu.gd.mic.principal_activity.pojo.Class
import cu.gd.mic.principal_activity.pojo.Lection


class LectionsFragment : Fragment(),ILessonFragment {

    private var lections =mutableListOf<Lection>()
    private var classes =mutableListOf<Class>()
    private lateinit var rvLectionsList:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v =inflater.inflate(R.layout.fragment_lections, container, false)
        rvLectionsList = v.findViewById(R.id.rv_lections_list)
        clearRecyclers()
        generateLayout()
        initClasses()
        initLeasson()
        generateAdapter()
        return v
    }
    override fun initClasses() {
        val lecc = Leccion.getLlecciones()
            val capitulos = lecc!![0].getCapitulos()
        capitulos!!.forEach {
            classes.add(Class(it.Nombre as String, it.Id as Int, it.IdLeccion as Int,it.Contenido as String,"Ta bueno?",true))
        }
    }
    override fun initLeasson() {
        val lecc = Leccion.getLlecciones()

        lecc!!.forEach {
            var saveInThis = mutableListOf<Class>()
            for (i in 0 until classes.size){
                if (classes[i].lessonId == it.Id){
                    Log.e("Clase","${classes[i].lessonId} is from ${it.Id}")
                    saveInThis.add(classes[i])
                }
            }
            lections.add(Lection(it.Id as Int,true,saveInThis))
        }
    }
    override fun clearRecyclers() {
        lections.clear()
        classes.clear()
    }

    override fun generateLayout() {
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rvLectionsList.layoutManager = linearLayoutManager
    }

    override fun generateAdapter() {
        val lectionAdapter = LectionAdapter(lections)
        rvLectionsList.adapter = lectionAdapter
    }

}
