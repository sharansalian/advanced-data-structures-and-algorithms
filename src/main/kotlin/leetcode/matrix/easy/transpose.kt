package leetcode.matrix.easy

fun transpose(A: Array<IntArray>): Array<IntArray> {
    val R = A.size
    val C = A[0].size
    val ans = Array(C) { IntArray(R) }
    for (r in 0 until R) for (c in 0 until C) {
        ans[c][r] = A[r][c]
    }
    return ans
}

fun main() {


    val matrx = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
    val m = matrx.size
    var n = matrx.first().size

    println("n: cols -> $n ")
    println("m: rows -> $m ")

    val transpose = transpose(matrx)

    for (a in transpose) {
        println(a.contentToString())
    }
}