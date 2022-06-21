package adv_kotlin.classes

data class Employee(val name: Name, val email: EmailData) {
    fun printName(string: String) {

    }
}

fun main() {
    val employee = Employee("Sharan", "sharan@.com")
    employee.printName("Sharan")
}

typealias Name = String

typealias EmailData = String