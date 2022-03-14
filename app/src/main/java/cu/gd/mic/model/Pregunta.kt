package cu.gd.mic.model

import com.activeandroid.Model
import com.activeandroid.annotation.Column
import com.activeandroid.annotation.Table

@Table(name = "Preguntas", id = "Id")
class Pregunta : Model() {

    @Column(name = "Id")
    var Id: Int? = null

    @Column(name = "cap_id")
    var IdCapitulo: Int? = null

    @Column(name = "pregunta")
    var Pregunta: String? = null

    @Column(name = "respuesta")
    var Respuesta: Int? = null

}