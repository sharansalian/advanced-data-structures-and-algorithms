package adv_kotlin.functions

fun foo(fooParam: String){
    val outsideFunction: String = "outside"
    fun bar(barParam: String) {
        println(barParam)
        println(fooParam)
        println(outsideFunction)
    }
}