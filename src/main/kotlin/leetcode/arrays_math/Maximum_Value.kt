package leetcode.arrays_math

fun main() {

    println(maxOf(intArrayOf(1, 15, 13, 8)))

    println(smartMaxOf(intArrayOf(1, 15, 13, 8)))
}

//Find the pair of elements i,j
fun maxOf(a: IntArray): Pair<Int, Pair<Int, Int>> {
    var max = 0
    var pair: Pair<Int, Int> = Pair(-1, -1)

    for (i in 0 until a.size) {
        for (j in i + 1 until a.size) {
            val value = Math.abs(i - j) + Math.abs(a[i] - a[j])
            if (value > max) {
                pair = Pair(i, j)
            }
            max = Math.max(value, max)
        }
    }

    return Pair(max, pair)
}

/**
 * Critical problem!
 */
fun smartMaxOf(a: IntArray): Int {
    // max and min variables as described
    // in algorithm.
    var max1 = Int.MIN_VALUE
    var min1 = Int.MAX_VALUE
    var max2 = Int.MIN_VALUE
    var min2 = Int.MAX_VALUE
    for (i in a.indices) {

        // Updating max and min variables
        // as described in algorithm.
        max1 = Math.max(max1, a[i] + i)
        min1 = Math.min(min1, a[i] + i)
        max2 = Math.max(max2, a[i] - i)
        min2 = Math.min(min2, a[i] - i)
    }

    // Calculating maximum absolute difference.
    return Math.max(max1 - min1, max2 - min2)
}
