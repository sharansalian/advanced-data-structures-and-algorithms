import java.lang.IndexOutOfBoundsException

class LinkedListIterator<T>(private val list: LinkedList<T>) : Iterator<T>, MutableIterator<T> {

    private var index = 0

    private var lastNode: Node<T>? = null
    override fun hasNext(): Boolean {
        return index < list.size
    }

    override fun next(): T {
        //1
        if (index >= list.size) throw IndexOutOfBoundsException()
        //2
        lastNode = if (index == 0) {
            list.nodeAt(0)
        } else {
            lastNode?.next
        }
        //3
        index++
        return lastNode!!.value
    }

    override fun remove() {
        // 1
        if (index == 1) {
            list.pop()
        } else {
            // 2
            val prevNode = list.nodeAt(index - 2) ?: return
            // 3
            list.removeAfter(prevNode)
            lastNode = prevNode
        }
        index--
    }

}

fun main() {
    "printing doubles" example {
        val ll = LinkedList<Int>().apply {
            push(3)
            push(2)
            push(1)
        }
        println(ll)

        for (value in ll) {
            println("Double ${value * 2}")
        }
    }

    "removing elements" example {
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)
        println(list)
        list.remove(1)
        println(list)
    }

    "retaining elements" example {
        val ll: MutableCollection<Int> = LinkedList()
        ll.add(3)
        ll.add(2)
        ll.add(1)
        ll.add(4)
        ll.add(5)

        println(ll)
        ll.retainAll(listOf(3, 4, 5))
        println(ll)
    }

    "remove all elements" example {
        val ll: MutableCollection<Int> = LinkedList()
        ll.add(3)
        ll.add(2)
        ll.add(1)
        ll.add(4)
        ll.add(5)
        println(ll)
        ll.removeAll(listOf(3, 4, 5))
        println(ll)
    }

}