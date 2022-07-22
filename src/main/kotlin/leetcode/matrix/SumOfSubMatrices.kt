package leetcode.matrix


fun main() {
    val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    println(" Sum : ${sumSubMatrices(matrix)} ")

}

fun sumSubMatrices(matrix: Array<IntArray>): Int {
    var sum = 0

    val n = matrix.size
    val m = matrix.first().size

    println("n: $n")
    println("m: $m")

    for (top in 0 until n) {
        for (left in 0 until m) {
            for (bottom in top..n) {
                for (right in left..m) {
                    for (i in left until right) {
                        for (j in top until bottom) {
                            println("top : $top left: $left bottom: $bottom right: $right")
                            sum += matrix[i][j]
                        }
                    }
                }
            }
        }
    }

    return sum

}