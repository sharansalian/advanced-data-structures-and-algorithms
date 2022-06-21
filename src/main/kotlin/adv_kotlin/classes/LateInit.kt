package adv_kotlin.classes

interface Repository {
    fun getAll(): List<Customer>
}

class CustomerController() {

    // I won't initialize it here, bout someone will, inversion of control
    lateinit var repository: Repository

    fun index():String {
        return repository.getAll().toString()
    }
}

fun main() {
    val customerController = CustomerController()
    customerController.index()
}