package cu.gd.mic.model

import com.activeandroid.Model
import com.activeandroid.annotation.Column
import com.activeandroid.annotation.Table
import com.activeandroid.query.Select

@Table(name = "Capitulos", id = "Id")
class Capitulo : Model() {

    @Column(name = "Id")
    var Id: Int? = null

    @Column(name = "id_lecc")
    var IdLeccion: Int? = null

    @Column(name = "nombre")
    var Nombre: String? = null

    @Column(name = "img_src")
    var Imagen: String? = null

    @Column(name = "contenido")
    var Contenido: String? = null

    fun getPreguntas(): MutableList<Pregunta>? {
        return Select().from(Pregunta::class.java).execute<Pregunta>()
    }

}
