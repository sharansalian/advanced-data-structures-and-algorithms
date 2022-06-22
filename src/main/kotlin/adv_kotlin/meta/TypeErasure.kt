package adv_kotlin.meta

fun main() {

    val listOfStrings = listOf("One", "Two", "Three")

    val listNumbers = listOf(1, 2, 3)

}

fun <T> printList(list: List<T>) {

}

inline fun <reified T> erased(input: List<Any>) {
    if (input is T) {

    }
}

inline fun <reified T> typeInfo() {
    println(T::class)
}