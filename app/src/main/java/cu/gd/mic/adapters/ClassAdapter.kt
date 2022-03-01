package cu.gd.mic.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cu.gd.mic.R
import cu.gd.mic.principal_activity.pojo.Class
import cu.gd.mic.principal_activity.pojo.Lection

class ClassAdapter (
    private var classes: MutableList<Class>
) : RecyclerView.Adapter<ClassAdapter.ClassViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cv_class,parent,false)
        return ClassViewHolder(v)
    }

    override fun getItemCount(): Int {
        return classes.size
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        holder.bind(classes[position])

    }

    inner class ClassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvTitle: TextView = itemView.findViewById(R.id.title_of_class)

        fun bind(clase:Class){
            tvTitle.text = clase.title
        }
    }
}