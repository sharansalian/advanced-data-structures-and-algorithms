package leetcode


fun main() {
    val indices = arrayOf(intArrayOf(0, 1), intArrayOf(1, 1))

    println(oddCells(2, 3, indices))

}

fun oddCells(m: Int, n: Int, indices: Array<IntArray>): Int {
    var count = 0
    val row = IntArray(m)
    val col = IntArray(n)
    for (x in indices) {
        row[x[0]]++
        col[x[1]]++
    }
    for (i in 0 until m) for (j in 0 until n) {
        if ((row[i] + col[j]) % 2 != 0) count++
    }
    return count
}