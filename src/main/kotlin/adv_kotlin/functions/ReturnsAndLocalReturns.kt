package adv_kotlin.functions

fun containingFunction(){
    val numbers = 1..100
    numbers.forEach myLabel@{
        if(it % 5 == 0){
            return@myLabel //local return
        }
    }
    println("Hello!")
}

fun main() {
    containingFunction()
}