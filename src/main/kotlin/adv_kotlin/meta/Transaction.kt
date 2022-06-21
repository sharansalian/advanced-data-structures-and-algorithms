package adv_kotlin.meta

import java.lang.reflect.Type

class Transaction(val id: Int, val amount: Double, var description: String) {
    fun validate() {
        if (amount > 2000) {
            println("adv_kotlin.meta.Transaction is too large")
        }
    }
}

fun introspectInstance(obj: Any) {
    println("Class ${obj.javaClass.simpleName}")
    println("Properties \n")
    obj.javaClass.declaredFields.forEach {
        println("${it.name} of type ${it.type}")
    }
    println("Functions \n")
    obj.javaClass.declaredMethods.forEach {
        println(it.name)
    }

}

fun getType(obj: Type){
    println(obj.typeName)
}

fun main() {
    val transaction = Transaction(1, 200.0, "A simple transaction")
//    introspectInstance(transaction)

    getType(Transaction::class.java)

}