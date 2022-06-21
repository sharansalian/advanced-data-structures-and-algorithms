package adv_kotlin.delegation

class Rectangle(val width: Int, val height: Int) {
    fun area() = width * height
}

class Window(val bounds: Rectangle) {

    // Delegation
    val area = bounds.area()
}