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

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T>? {
        //1
        if (tail == afterNode) {
            append(value)
            return tail
        }

        //2
        val newNode = Node(value = value, next = afterNode.next)
        afterNode.next = newNode
        return newNode
    }
}

fun main() {
    "add, append, nodeAt & insert with fluent interface" example {
        val ll = LinkedList<Int>().apply {
            push(23)
            push(21)
            push(16)
            append(25)
        }
        println(ll)
        val index = 3
        val node = ll.nodeAt(index)
        println("The node at $index is ${node?.value}")
        node?.let { ll.insert(22, it) }
        println(ll)
    }
}