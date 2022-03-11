package practice

typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(value: TreeNode<T>) = children.add(value)

    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)
        val queue = ArrayListQueue<TreeNode<T>>()
        children.forEach { queue.enqueue(it) }

        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }

    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null

        forEachLevelOrder {
            if (it.value == value)
                result = it
        }
        return result
    }
}

interface Queue<T> {
    fun enqueue(value: T): Boolean
    fun dequeue(): T?
    fun peek(): T?
    val count: Int
    fun isEmpty(): Boolean = count == 0
}

class ArrayListQueue<T> : Queue<T> {
    private val list = arrayListOf<T>()

    override fun enqueue(value: T): Boolean {
        list.add(value)
        return true
    }

    override fun dequeue(): T? {
        return if (isEmpty()) null else list.removeAt(0)
    }

    override val count: Int
        get() = list.size

    override fun peek(): T? {
        return list.getOrNull(0)
    }

    override fun toString(): String {
        return list.toString()
    }

}

fun main() {
    val tree = TreeNode("Amm")
    val mom = TreeNode("mom")
    val lekha = TreeNode("lekha")
    val kumar = TreeNode("kumar")
    val shal = TreeNode("shal")
    val shar = TreeNode("shar")
    val div = TreeNode("div")
    val apu = TreeNode("apu")

    tree.add(mom)
    tree.add(lekha)
    tree.add(kumar)

    mom.add(shal)
    mom.add(shar)

    lekha.add(div)

    kumar.add(apu)


    tree.forEachLevelOrder {
//        println(it.value)
    }

    val result = tree.search("kumar")
    println("${result?.value}")
}

