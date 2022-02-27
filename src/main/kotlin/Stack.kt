interface Stack<Element> {

    fun push(element: Element)
    fun pop(): Element?
}


class AndroidStack<T : Any>() : Stack<T> {
    private val storage = arrayListOf<T>()

    override fun toString() = buildString {
        appendln("---top---")
        storage.asReversed().forEach {
            appendln("$it")
        }
        appendln("----------")
    }

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (storage.size == 0) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }
}

fun main() {
    "using a stack" example {
        val stack = AndroidStack<String>().apply {
            push("Home")
            push("Mail List")
            push("Mail Message")
            push("Browser")
            push("Map")
        }
        print(stack)
        val poppedElement = stack.pop()
        if (poppedElement != null) {
            println("Popped: $poppedElement")
        }
        print(stack)
    }
}