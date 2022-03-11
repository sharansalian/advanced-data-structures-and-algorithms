package binarytree

data class BinaryNode<T>(val value: T) {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    /**
     * If the current node has a left child, recursively visit this child first
     *
     * Then visit the node itself
     *
     * If the current node has a right child, recursively visit theis child
     */
    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    /**
     * Visit the current node first
     *
     * Recursively visits the left and right child
     */
    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    /**
     * Recursively visit the left and right child
     *
     * Only visit the current node after the left and right child have been visited recursively
     */
    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }
}


fun main() {
    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)

    seven.leftChild = one
    seven.rightChild = nine
    one.leftChild = zero
    one.rightChild = five
    nine.leftChild = eight

    val tree = seven

    println("In Order Traversal")
    tree.traverseInOrder {
        println(it)
    }

    println("Pre Order Traversal")
    tree.traversePreOrder {
        println(it)
    }

    println("Post Order Traversal")
    tree.traversePostOrder {
        println(it)
    }
}

typealias Visitor<T> = (T) -> Unit


