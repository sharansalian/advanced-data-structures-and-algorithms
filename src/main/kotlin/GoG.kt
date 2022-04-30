internal class MyCircularQueue(k: Int) {
    private val data: IntArray
    private var head: Int
    private var tail: Int
    private val size: Int

    /** Initialize your data structure here. Set the size of the queue to be k.  */
    init {
        data = IntArray(k)
        head = -1
        tail = -1
        size = k
    }

    /** Insert an element into the circular queue. Return true if the operation is successful.  */
    fun enQueue(value: Int): Boolean {
        if (isFull == true) {
            return false
        }
        if (isEmpty == true) {
            head = 0
        }
        tail = (tail + 1) % size
        data[tail] = value
        return true
    }

    /** Delete an element from the circular queue. Return true if the operation is successful.  */
    fun deQueue(): Boolean {
        if (isEmpty == true) {
            return false
        }
        if (head == tail) {
            head = -1
            tail = -1
            return true
        }
        head = (head + 1) % size
        return true
    }

    /** Get the front item from the queue.  */
    fun Front(): Int {
        return if (isEmpty == true) {
            -1
        } else data[head]
    }

    /** Get the last item from the queue.  */
    fun Rear(): Int {
        return if (isEmpty == true) {
            -1
        } else data[tail]
    }

    /** Checks whether the circular queue is empty or not.  */
    val isEmpty: Boolean
        get() = head == -1

    /** Checks whether the circular queue is full or not.  */
    val isFull: Boolean
        get() = (tail + 1) % size == head
}