package adv_kotlin.functions

infix fun String.shouldBeEqualTo(value: String) = this == value

fun main() {
    "Hello".shouldBeEqualTo("Hello")

    "Hello" shouldBeEqualTo  "Hello"

}