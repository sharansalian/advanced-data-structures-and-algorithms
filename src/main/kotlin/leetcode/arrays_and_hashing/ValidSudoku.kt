package leetcode.arrays_and_hashing

fun main() {
    generateMatrix()
}

fun generateMatrix() {
    val matrix = Array<IntArray>(3) { r ->
        when (r) {
            0 -> intArrayOf(1, 10, 5)
            1 -> intArrayOf(3, 8, 7)
            2 -> intArrayOf(4, 3, 2)
            else -> intArrayOf()
        }
    }

    matrix[0][2] = 8

    for (row in matrix) {
        println(row.contentToString())
    }
}