class LinkedList<T> {

    var head: Node<T>? = null
    var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean = size == 0

    override fun toString(): String {
        return if (isEmpty())
            "Empty List"
        else
            head.toString()
    }

    fun push(value: T) {
        head = Node(value = value, head)
        if (tail == null) {
            tail = head
        }
        size++
    }
}

fun main() {
    "pushing in linked list" example {
        val ll = LinkedList<Int>()
        ll.push(3)
        ll.push(2)
        ll.push(1)

        println(ll)

    }
}