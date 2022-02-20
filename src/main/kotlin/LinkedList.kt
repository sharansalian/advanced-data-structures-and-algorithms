class LinkedList<T> : Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T> {

    var head: Node<T>? = null
    var tail: Node<T>? = null
    override var size = 0
        private set

    override fun isEmpty(): Boolean = size == 0

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

        while (next != null) {
            prev = curr
            curr = next
            next = curr.next
        }

        //5
        prev.next = null
        tail = prev
        return curr.value
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value

        if (node == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }

        node.next = node.next?.next
        return result
    }

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    // O(n)
    override fun contains(element: T): Boolean {
        for (item in this) {
            if (item == element) return true
        }
        return false
    }

    // O^2
    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements) {
            if (!contains(searched)) return false
        }
        return true
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            append(element)
        }
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item == element) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements) {
            result = remove(item) || result
        }
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }
        return result
    }
}

fun main() {
    "add, append, nodeAt, insert, pop, removeLast, remove with fluent interface" example {
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
        val removeAfterNodeIndex = 1
        val nodeAt = ll.nodeAt(removeAfterNodeIndex)
        println(ll)
        ll.append(33).append(38)
        println(ll)
        println("The node at $removeAfterNodeIndex is ${nodeAt?.value}")
        val removedNode = nodeAt?.let { ll.removeAfter(it) }
        println(ll)
        println("The removed node $removedNode")
    }
}