package cu.gd.mic.classes

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import cu.gd.mic.R

class ClassActivity : AppCompatActivity() {
    private var title:String?= null
    private var textClass:String?= null
    private var question:String?= null
    private var answer:Boolean = false
    private lateinit var tvTitle:TextView
    private lateinit var tvTextClass:TextView
    private lateinit var tvQuestion:TextView
    private lateinit var rbTrue:RadioButton
    private lateinit var rbFalse:RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)
        //Extras
        val bundle = intent.extras
        title = bundle!!.getString("title")
        textClass = bundle!!.getString("text_class")
        question = bundle!!.getString("question")
        answer =when(bundle!!.getInt("answer")){
            0-> false
            else->true
        }
        //Views
        tvTitle = findViewById(R.id.tv_title_in_class)
        tvTextClass = findViewById(R.id.tv_context_in_class)
        tvQuestion = findViewById(R.id.tv_question_in_class)
        rbTrue = findViewById(R.id.rb_true_in_class)
        rbFalse = findViewById(R.id.rb_false_in_class)
        tvTitle.text = title
        tvTextClass.text = textClass
        tvQuestion.text = question

    }
    fun show_Error() {
        val sb = Snackbar.make(
            findViewById(R.id.coordinator_class),
            "",
            Snackbar.LENGTH_SHORT
        )
        val customSnackView = layoutInflater.inflate(R.layout.custom_snackbar_view, null)
        sb.view.setBackgroundColor(Color.TRANSPARENT)
        val snackbarLayout = sb.view as Snackbar.SnackbarLayout
        snackbarLayout.setPadding(10, 10, 10, 10)
        snackbarLayout.addView(customSnackView, 0)
        sb.show()
    }
    fun show_Acepted() {
        val sb = Snackbar.make(
            findViewById(R.id.coordinator_class),
            "",
            Snackbar.LENGTH_SHORT
        )
        val customSnackView = layoutInflater.inflate(R.layout.custom_snackbar_view_acepted, null)
        sb.view.setBackgroundColor(Color.TRANSPARENT)
        val snackbarLayout = sb.view as Snackbar.SnackbarLayout
        snackbarLayout.setPadding(10, 10, 10, 10)
        snackbarLayout.addView(customSnackView, 0)
        sb.show()
    }
    fun show_Sugestion() {
        val sb = Snackbar.make(
            findViewById(R.id.coordinator_class),
            "",
            Snackbar.LENGTH_SHORT
        )
        val customSnackView = layoutInflater.inflate(R.layout.custom_snackbar_view_sugestion, null)
        sb.view.setBackgroundColor(Color.TRANSPARENT)
        val snackbarLayout = sb.view as Snackbar.SnackbarLayout
        snackbarLayout.setPadding(10, 10, 10, 10)
        snackbarLayout.addView(customSnackView, 0)
        sb.show()
    }
    fun checkAnswer(v: View){
        if (rbTrue.isChecked || rbFalse.isChecked){
            val sp = getSharedPreferences("Results", Context.MODE_PRIVATE)

            val corrects = sp.getInt("corrects",0)
            val incorrects = sp.getInt("incorrects",0)
        val checked = rbTrue.isChecked
        if(checked == answer){
            show_Acepted()
            saveResults(corrects+1,incorrects,sp)
        }
        else{
            show_Error()
            saveResults(corrects,incorrects+1,sp)
        }
        }else
            show_Sugestion()
    }
    fun saveResults(corrects:Int,incorrects:Int,sp:SharedPreferences){
        val editor = sp.edit()
        editor.putInt("corrects",corrects)
        editor.putInt("incorrects",incorrects)
        editor.commit()
    }
    fun goBack(v:View){
        super.onBackPressed()
    }

}
