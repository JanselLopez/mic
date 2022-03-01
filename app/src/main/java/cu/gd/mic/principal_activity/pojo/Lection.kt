package cu.gd.mic.principal_activity.pojo

data class Lection(
    var lectionNumber:Int,
    var isOpen:Boolean,
    var classes:MutableList<Class>
)