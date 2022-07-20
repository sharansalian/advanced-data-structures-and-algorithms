package leetcode.matrix


fun main() {
    val matrix = arrayOf(intArrayOf(44, 1), intArrayOf(1, 1))
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
            for (bottom in top .. n) {
                for (right in left .. m) {
                    for (i in left until right) {
                        for (j in top until bottom) {
                            println("i: $i, j : $j -> ${matrix[i][j]}")
                            sum += matrix[i][j]
                        }
                    }
                }
            }
        }
    }

    return sum

}