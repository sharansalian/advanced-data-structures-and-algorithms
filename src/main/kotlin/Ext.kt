infix fun String.example(function: () -> Unit) {
    println("Example of $this")
    function()
    println()
}

fun main() {
    "Data Structures & algorithms".example {
        println("Linked List")
    }
}