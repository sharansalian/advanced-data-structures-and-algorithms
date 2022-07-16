package leetcode.matrix

/**
 *
Input: mat = [  [1,2,3],
[4,5,6],
[7,8,9]
]
 */

fun main() {

    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    println(diagonalSum(matrix))
}


fun diagonalSum(matrix: Array<IntArray>): Int {

    var sum = 0

    var principal = 0
    var secondary = 0

    val n = matrix.first().size

    for (i in 0 until n) {
        println("Primary : ${matrix[i][i]}")
        println("Secondary : ${matrix[i][n - i - 1]}")

        sum += matrix[i][i]
        if (i != (n - i - 1)) sum += matrix[i][n-i-1]

    }

    return sum
}