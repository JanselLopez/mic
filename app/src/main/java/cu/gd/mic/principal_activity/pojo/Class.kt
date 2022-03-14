package cu.gd.mic.principal_activity.pojo

data class Class(
    val title:String,
    var id:Int,
    var lessonId:Int,
    var textClass:String,
    var question:String,
    var answer:Boolean
)