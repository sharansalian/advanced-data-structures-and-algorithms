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

// Definition for singly-linked list.
class SinglyListNode(var `val`: Int) {
    var next: SinglyListNode? = null
}

internal class MyLinkedList /** Initialize your data structure here.  */ {
    private var head: SinglyListNode? = null

    /** Helper function to return the index-th node in the linked list.  */
    private fun getNode(index: Int): SinglyListNode? {
        var cur: SinglyListNode? = head
        var i = 0
        while (i < index && cur != null) {
            cur = cur.next
            ++i
        }
        return cur
    }

    /** Helper function to return the last node in the linked list.  */
    private fun getTail(): SinglyListNode? {
        var cur: SinglyListNode? = head
        while (cur?.next != null) {
            cur = cur.next
        }
        return cur
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1.  */
    fun get(index: Int): Int {
        val cur = getNode(index)
        return cur?.`val` ?: -1
    }


    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.  */
    fun addAtHead(`val`: Int) {
        val cur = SinglyListNode(`val`)
        cur.next = head
        head = cur
        return
    }

    /** Append a node of value val to the last element of the linked list.  */
    fun addAtTail(`val`: Int) {
        if (head == null) {
            addAtHead(`val`)
            return
        }
        val prev = getTail()
        val cur = SinglyListNode(`val`)
        prev!!.next = cur
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index == 0) {
            addAtHead(`val`)
            return
        }
        val prev = getNode(index - 1) ?: return
        val cur = SinglyListNode(`val`)
        val next = prev.next
        cur.next = next
        prev.next = cur
    }


    /** Delete the index-th node in the linked list, if the index is valid.  */
    fun deleteAtIndex(index: Int) {
        val cur = getNode(index) ?: return
        val next = cur.next
        if (index == 0) {
            // modify head when deleting the first node.
            head = next
        } else {
            val prev = getNode(index - 1)
            prev!!.next = next
        }
    } 


}
