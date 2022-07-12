internal class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val list: MutableList<Int> = ArrayList()
        var rb = 0
        var re = matrix.size - 1
        var cb = 0
        var ce = matrix[0].size - 1

        while (rb <= re && cb <= ce) {
            for (j in cb..ce) {
                list.add(matrix[rb][j])
            }
            rb++
            for (i in rb..re) {
                list.add(matrix[i][ce])
            }
            ce--
            if (rb <= re) {
                for (j in ce downTo cb) {
                    list.add(matrix[re][j])
                }
            }
            re--
            if (cb <= ce) {
                for (i in re downTo rb) {
                    list.add(matrix[i][cb])
                }
            }
            cb++
        }
        return list
    }
}