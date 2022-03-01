package cu.gd.mic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cu.gd.mic.R
import cu.gd.mic.fragments.sections_fragments.LectionsFragment
import cu.gd.mic.principal_activity.pojo.Lection
import kotlinx.android.synthetic.main.cv_lection.view.*

class LectionAdapter(
    private var lections: MutableList<Lection>
) :RecyclerView.Adapter<LectionAdapter.LectionViewHolder>(){
    private lateinit var contextParent: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LectionViewHolder {
        contextParent = parent.context
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cv_lection,parent,false)
        return LectionViewHolder(v)
    }

    override fun getItemCount(): Int {
        return lections.size
    }

    override fun onBindViewHolder(holder: LectionViewHolder, position: Int) {
        holder.bind(lections[position],contextParent)
    }

    inner class LectionViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val ivLock:ImageView = itemView.findViewById(R.id.iv_lock)
        val tvTitle:TextView = itemView.findViewById(R.id.tv_leccion_number)
        val recycler:RecyclerView = itemView.findViewById(R.id.rv_class)
        fun bind(lection: Lection,context: Context){

            if (lection.isOpen)
                ivLock.setImageResource(R.drawable.ic_lock_open_black_24dp)
            else
                ivLock.setImageResource(R.drawable.ic_lock_outline_black_24dp)

            tvTitle.text = "Lección${lection.lectionNumber}"

            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
            recycler.layoutManager = linearLayoutManager
            val classAdapter = ClassAdapter(lection.classes)
            recycler.adapter = classAdapter

        }
    }
}