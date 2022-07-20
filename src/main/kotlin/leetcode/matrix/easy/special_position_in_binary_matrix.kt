package leetcode.matrix.easy


fun numSpecial(mat: Array<IntArray>): Int {
    val n = mat.size
    val m = mat[0].size
    var res = 0
    val col = IntArray(m)
    val row = IntArray(n)
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (mat[i][j] == 1) {
                col[j]++
                row[i]++
            }
        }
    }
    for (i in 0 until n) for (j in 0 until m) {
        if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) res++
    }
    return res
}

fun main() {

    val mat = arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 0, 1), intArrayOf(1, 0, 0))
    numSpecial(mat)
}