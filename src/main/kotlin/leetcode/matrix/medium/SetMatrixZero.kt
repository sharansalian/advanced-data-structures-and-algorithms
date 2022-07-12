package leetcode.matrix.medium


fun main() {

    val matrix = arrayOf(
        intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1)
    )

    setZeros(matrix)
}


fun setZeros(matrix: Array<IntArray>): Unit {

    val row = matrix.size
    val col = matrix.first().size

    println("Row $row , COl $col")

    val rows = hashSetOf<Int>()
    val cols = hashSetOf<Int>()

    for (i in 0 until row) {
        for (j in 0 until col) {
            if (matrix[i][j] == 0) {
                rows.add(i)
                cols.add(i)
            }
        }
    }

    for (i in 0 until row) {
        for (j in 0 until col) {
            if (i in rows || j in cols) {
                matrix[i][j] = 0
            }
        }
    }


    for (iA in matrix) {
        println(iA.contentToString())
    }
}

internal class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        var isCol = false
        val R = matrix.size
        val C = matrix[0].size
        for (i in 0 until R) {

            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true
            }
            for (j in 1 until C) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0
                    matrix[i][0] = 0
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (i in 1 until R) {
            for (j in 1 until C) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (j in 0 until C) {
                matrix[0][j] = 0
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (i in 0 until R) {
                matrix[i][0] = 0
            }
        }
    }
}