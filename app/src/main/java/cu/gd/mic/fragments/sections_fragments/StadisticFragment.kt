package cu.gd.mic.fragments.sections_fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import cu.gd.mic.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import android.graphics.Color
import com.github.mikephil.charting.components.Description


class StadisticFragment : Fragment() {

    var pieChart: PieChart? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v =inflater.inflate(R.layout.fragment_stadistic, container, false)
        pieChart = v.findViewById(R.id.pieChart_view)
        showWithPreference()
        return v
    }

    override fun onResume() {
        super.onResume()
        showWithPreference()
    }

    private fun showWithPreference(){
        val preferences = this.activity!!.getSharedPreferences("Results",Context.MODE_PRIVATE)
        val corrects = preferences.getInt("corrects",0)
        val incorrects = preferences.getInt("incorrects",0)
        showPieChart(corrects,incorrects)
    }

    private fun showPieChart(corrects:Int,incorrects:Int) {
        val pieEntries = mutableListOf<PieEntry>()
        val label = "Respuestas"
        //initializing data
        val typeAmountMap = hashMapOf<String,Int>()
        typeAmountMap["Incorrectas"] = incorrects
        typeAmountMap["Correctas"] = corrects
        typeAmountMap["Sin realizar"] = 45
        //initializing colors for the entries
        val colors = mutableListOf<Int>()
        colors.add(Color.parseColor("#FF1744"))
        colors.add(Color.parseColor("#00E676"))
        colors.add(Color.parseColor("#BDBDBD"))
        //input data and fit data into pie chart entry
        for (type in typeAmountMap.keys) {
            pieEntries.add(PieEntry(typeAmountMap[type]!!.toFloat(), type))
        }
        //collecting the entries with label name
        val pieDataSet = PieDataSet(pieEntries, label)
        //setting text size of the value
        pieDataSet.valueTextSize = 14f
        //providing color list for coloring different entries
        pieDataSet.colors = colors
        //
        pieDataSet.valueTextColor = Color.parseColor("#F4F4F8")
        //
        pieDataSet.setValueTextColors(mutableListOf(Color.parseColor("#F4F4F8")))
        //grouping the data set from entry to chart
        val pieData = PieData(pieDataSet)
        //
        val description = Description()
        description.textColor =  Color.parseColor("#F4F4F8")
        description.text = "Leyenda"
        //
        //showing the value of the entries, default true if not set
        pieData.setDrawValues(true)
        pieChart!!.description = description
        pieChart!!.legend.textColor =Color.parseColor("#F4F4F8")
        pieChart!!.legend.textSize =14f
        pieChart!!.data = pieData
        pieChart!!.invalidate()
    }

}
