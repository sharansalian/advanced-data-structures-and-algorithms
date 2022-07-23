package leetcode.matrix.easy


fun main() {
    val matrix = arrayOf(intArrayOf(10, 20, 30), intArrayOf(5, 10, 20), intArrayOf(2, 4, 6))

}

fun prefixSumMatrix(matrix: Array<IntArray>){

}

// Java program to find prefix sum of 2D array


internal object GFG {
    // calculating new array
    fun prefixSum2D(a: Array<IntArray>) {
        val R = a.size
        val C = a[0].size
        val psa = Array(R) { IntArray(C) }
        psa[0][0] = a[0][0]

        // Filling first row and first column
        for (i in 1 until C) psa[0][i] = psa[0][i - 1] + a[0][i]
        for (i in 1 until R) psa[i][0] = psa[i - 1][0] + a[i][0]

        // updating the values in the
        // cells as per the general formula.
        for (i in 1 until R) for (j in 1 until C)  // values in the cells of new array
        // are updated
            psa[i][j] = psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1] + a[i][j]

        //printing
        for (i in 0 until R) {
            for (j in 0 until C) print(psa[i][j].toString() + " ")
            println()
        }
    }

    // driver code
    @JvmStatic
    fun main(args: Array<String>) {
        val a = arrayOf(intArrayOf(10, 20, 30), intArrayOf(5, 10, 20), intArrayOf(2, 4, 6))
        prefixSum2D(a)
    }
}
