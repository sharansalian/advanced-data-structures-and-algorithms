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

    /**
     * head first insertion
     */
    fun push(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    /***
     * tail-end insertion
     */
    fun append(value: T): LinkedList<T> {
        //1
        if (isEmpty()) {
            push(value)
            return this
        }

        //2
        tail?.next = Node(value = value)

        //3
        tail = tail?.next

        size++
        return this
    }
}

fun main() {
    "add & append with fluent interface" example {
        val ll = LinkedList<Int>().apply {
            push(23)
            push(21)
            push(16)
            append(25)
        }
        println(ll)
    }
}