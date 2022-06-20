fun main() {
    val arr = IntArray(5)
    println(arr.contentToString())
    arr[0] = 1
    arr[2] = 100
    println(arr.contentToString())
    arr[0] = 555
    println(arr.contentToString())
}