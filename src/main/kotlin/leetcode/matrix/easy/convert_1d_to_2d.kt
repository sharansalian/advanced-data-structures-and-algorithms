package leetcode.matrix.easy

fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray>? {
    if (original.size != m * n) return Array(0) { IntArray(0) }
    val result = Array(m) { IntArray(n) }
    for (i in original.indices) {
        result[i / n][i % n] = original[i]
    }
    return result
}

fun main() {

    construct2DArray(intArrayOf(1, 2, 3, 4), 2, 2)
}