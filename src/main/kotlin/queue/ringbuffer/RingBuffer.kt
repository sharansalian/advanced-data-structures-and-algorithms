package queue.ringbuffer

class RingBuffer<T : Any>(private val size: Int) {

    private var array = ArrayList<T?>(size)
    var readIndex = 0
    var writeIndex = 0

    fun rear(): Any? = array.getOrElse((writeIndex - 1) % size) { -1 }

    fun front(): Any? = array.getOrElse((readIndex) % size) { -1 }

    val count: Int
        get() = availableSpaceForReading

    private val availableSpaceForReading: Int
        get() = (writeIndex - readIndex)

    val first: T?
        get() = array.getOrNull(readIndex)

    val isEmpty: Boolean
        get() = (count == 0)

    private val availableSpaceForWriting: Int
        get() = (size - availableSpaceForReading)

    val isFull: Boolean
        get() = (availableSpaceForWriting == 0)

    fun write(element: T): Boolean {
        return if (!isFull) {
            if (array.size < size) {
                array.add(element)
            } else {
                array[writeIndex % size] = element
            }
            writeIndex += 1
            true
        } else {
            false
        }
    }

    fun read(): T? {
        return if (!isEmpty) {
            val element = array[readIndex % size]
            readIndex += 1
            element
        } else {
            null
        }
    }


    override fun toString(): String {
        val values = (0 until availableSpaceForReading).map { offset ->
            "${array[(readIndex + offset) % size]!!}"
        }
        return array.joinToString(prefix = "[", separator = ", ", postfix = "]")
    }
}