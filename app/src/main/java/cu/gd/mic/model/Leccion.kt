package cu.gd.mic.model

import com.activeandroid.Model
import com.activeandroid.annotation.Column
import com.activeandroid.annotation.Table
import com.activeandroid.query.Select

@Table(name = "Lecciones", id = "Id")
class Leccion : Model() {

    @Column(name = "Id")
    var Id: Int? = null

    @Column(name = "nombre")
    var Nombre: String? = null

    fun getCapitulos(): MutableList<Capitulo>? {
        return Select().from(Capitulo::class.java).execute<Capitulo>()
    }

    companion object{
        fun getLlecciones(): MutableList<Leccion>? {
            return Select().from(Leccion::class.java).execute<Leccion>()
        }
    }
}
