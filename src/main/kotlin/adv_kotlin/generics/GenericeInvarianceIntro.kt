package adv_kotlin.generics

open class Person

class Employee : Person()

fun operate(person: Person) {
}

fun operate(persons: Array<Person>): Array<Person> {
    val person = Person()
    persons[0] = person
    return persons

}
fun operate(persons: List<Person>){

}


fun main() {
    operate(Person())

    //Because Employee is subtype Person
    operate(Employee())

    operate(arrayOf(Person(), Person()))

    val result = operate(List<Employee>(1) {Employee()})

    val x = 1
}