class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else "$value"
    }
}

fun main() {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    node1.next = node2
    node2.next = node3

    println(node1)
}