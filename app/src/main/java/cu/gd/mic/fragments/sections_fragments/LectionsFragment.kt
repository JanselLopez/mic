package cu.gd.mic.fragments.sections_fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import cu.gd.mic.R
import cu.gd.mic.adapters.LectionAdapter
import cu.gd.mic.principal_activity.pojo.Class
import cu.gd.mic.principal_activity.pojo.Lection


class LectionsFragment : Fragment() {

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
        lections.clear()
        classes.clear()
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rvLectionsList.layoutManager = linearLayoutManager
        classLeccionUno()
        lections.add(Lection(1,true,classes))
        val lectionAdapter = LectionAdapter(lections)
        rvLectionsList.adapter = lectionAdapter
        return v
    }
    private fun classLeccionUno(){
        classes.add(Class("Que es una investigacion cientifica"))
        classes.add(Class("Como comienza una investigacion cientifica"))
    }

}
