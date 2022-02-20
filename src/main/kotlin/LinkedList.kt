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
        size++
        return newNode
    }

    /**
     * removes the value at the front of the list
     */
    fun pop(): T? {
        if (isEmpty()) size--

        val result = head?.value
        head = head?.next

        if (isEmpty()) {
            tail = null
        }

        return result
    }

    fun removeLast(): T? {

        //1
        val head = head ?: return null

        //2
        if (head.next == null) return pop()

        //3
        size--

        //4
        var prev = head
        var curr = head

        var next = curr.next

        while (next != null){
            prev = curr
            curr = next
            next = curr.next
        }

        //5
        prev.next = null
        tail = prev
        return curr.value

    }
}

fun main() {
    "add, append, nodeAt, insert, pop & removeLast with fluent interface" example {
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
        val poppedElement = ll.pop()
        println("The popped element is $poppedElement")
        println(ll)
        val lastElm = ll.removeLast()
        println("The removed last element is $lastElm")
    }
}