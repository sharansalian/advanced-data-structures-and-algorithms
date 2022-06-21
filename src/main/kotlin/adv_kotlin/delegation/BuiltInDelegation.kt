package adv_kotlin.delegation


import kotlin.properties.Delegates

data class Employee(val name: Name, val email: EmailData) {

    var department: String by Delegates.observable("") { property, oldValue, newValue ->
        println("Property ${property.name} OldValue :$oldValue NewValue: $newValue")
    }

    fun printName(string: String) {

    }
}

fun main() {
    val employee = Employee("Sharan", "sharan@.com")
    employee.printName("Sharan")
    employee.department = "IT"

    val veto = Veto()
    println(veto.value)
    veto.value = "London"
    println(veto.value)
    veto.value = "Spain"
    println(veto.value)
}

typealias Name = String

typealias EmailData = String

class Veto {
    var value: String by Delegates.vetoable("String") { property, old, new -> new.startsWith("S") }
}