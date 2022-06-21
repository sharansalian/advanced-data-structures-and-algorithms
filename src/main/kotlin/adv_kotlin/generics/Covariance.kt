package adv_kotlin.generics

import adv_kotlin.classes.Customer

open class Person

class Employee : Person()

fun operate(person: Person) {
}

fun operate(persons: Array<Person>): Array<Person> {
    val person = Person()
    persons[0] = person
    return persons

}

fun operate(persons: List<Person>) {

}


fun main() {
    operate(Person())

    //Because Employee is subtype Person
    operate(Employee())

    operate(arrayOf(Person(), Person()))

    operate(listOf<Employee>())
    operate(listOf<Person>())

    val readOnlyRepo = ReadOnlyRepoImpl<Customer>()

    readOnlyRepo.getId(1)
    readOnlyRepo.getAll()

}

// Declaration site variance
interface ReadOnlyRepo<out T> {
    fun getId(id: Int): T
    fun getAll(): List<T>

}