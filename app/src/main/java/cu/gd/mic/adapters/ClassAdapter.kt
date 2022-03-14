package cu.gd.mic.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import cu.gd.mic.R
import cu.gd.mic.classes.ClassActivity

import cu.gd.mic.principal_activity.pojo.Class
import cu.gd.mic.principal_activity.pojo.Lection

class ClassAdapter (
    private var classes: MutableList<Class>
) : RecyclerView.Adapter<ClassAdapter.ClassViewHolder>(){
    private lateinit var contextParent: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        contextParent = parent.context
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
        val linear: CardView = itemView.findViewById(R.id.cv_lesson_card)

        fun bind(clase:Class){
            tvTitle.text = clase.title
            linear.setOnClickListener {
                val intent = Intent(contextParent,ClassActivity::class.java)
                intent.putExtra("title",clase.title)
                intent.putExtra("text_class",clase.textClass)
                intent.putExtra("question",clase.question)
                intent.putExtra("answer",clase.answer)
                startActivity(contextParent,intent,null)
            }
        }

    }
}