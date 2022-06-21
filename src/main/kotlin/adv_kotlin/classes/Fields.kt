package adv_kotlin.classes

class Customer() {
    var lastPurchasedAmount: Double = 0.0
        get() = field
        set(value)  {
            if (value > 100){
                field = value
            }
        }
}

fun main() {
    val customer = Customer()

    println(customer.lastPurchasedAmount)
    customer.lastPurchasedAmount = 200.0
    println(customer.lastPurchasedAmount)
    customer.lastPurchasedAmount = 50.0
    println(customer.lastPurchasedAmount)
}