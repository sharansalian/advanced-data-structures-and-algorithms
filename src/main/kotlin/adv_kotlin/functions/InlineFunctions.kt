package adv_kotlin.functions

fun operation(op: () -> Unit){
    println("Before calling op")
    op()
    println("After calling op")
}

fun main() {
    operation {
      println("This is the actual op function")
    }
}