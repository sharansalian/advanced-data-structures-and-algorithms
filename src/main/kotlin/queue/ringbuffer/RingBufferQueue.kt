package queue.ringbuffer

import example
import practice.Queue

class RingBufferQueue<T : Any>(size: Int) : Queue<T> {

    private val ringBuffer: RingBuffer<T> = RingBuffer(size)

    override fun enqueue(value: T): Boolean =
        ringBuffer.write(value)

    override fun dequeue(): T? =
        if (isEmpty()) null else ringBuffer.read()

    override fun peek(): T? = ringBuffer.first

    override val count: Int
        get() = ringBuffer.count

    override fun toString(): String = ringBuffer.toString()


    val front: Any?
        get() = ringBuffer.front()

    val rear: Any?
        get() = ringBuffer.rear()
}

fun main() {
    /*
    ["MyCircularQueue","enQueue","Rear","Front","deQueue","Front",

    "deQueue","Front","enQueue","enQueue","enQueue","enQueue"]

    [[3],[2],[],[],[],[],[],[],[4],[2],[2],[3]]*/
    "Queue with Ring Buffer" example {
        val queue = RingBufferQueue<Int>(3).apply {
            enqueue(2)


        }
        println(queue)
        println(queue.rear)
        println(queue.front)
        /*   queue.dequeue()
           println(queue)
           println("Next up: ${queue.peek()}")*/
    }
}