package adv_kotlin.delegation

val String.hasAmpersand
get() = this.contains("&")

fun main() {
    println("Hello".hasAmpersand)
    println("Hello & Bye".hasAmpersand)
}