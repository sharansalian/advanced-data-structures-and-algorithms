package leetcode.matrix.medium

import leetcode.matrix.easy.prefixSumMatrix

class NumMatrix(val matrix: Array<IntArray>) {

    val psm = Array(matrix.size) { IntArray(matrix.first().size) }

    init {
        var r = matrix.size
        var c = matrix.first().size

        psm[0][0] = matrix[0][0]

        for(i in 1 until c) psm[0][i] = psm[0][i - 1] + matrix[0][i]
        for(i in 1 until r) psm[i][0] = psm[i - 1][0] + matrix[i][0]

        for(i in 1 until r){
            for(j in 1 until c){
                psm[i][j] = psm[i -1][j] + psm[i][j -1] - psm[i -1][j-1] + matrix[i][j]
            }
        }

    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        val top = row1
        val left = col1
        val bottom = row2
        val right = col2

        if(row1 == 0 && row2 == 0){
           return psm[row2][col2]
        }

        if(row1 == 0){
            return psm[row2][col2] - psm[row2][col1 - 1]
        }

        if (col1 == 0) {
            return psm[row2][col2] - psm[row1 - 1][col2]
        }

        return psm[row2][col2] - psm[row1 - 1][col2] - psm[row2][col1 - 1] + matrix[row1 - 1][col1 - 1]
    }

}