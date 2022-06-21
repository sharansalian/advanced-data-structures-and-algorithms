package adv_kotlin.delegation

fun localDelegate() {
    val lazy by lazy { initiate() }
}

fun initiate() : String{
    return "String"
}
