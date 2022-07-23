package leetcode.matrix.easy

fun matrixReshape(nums: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
    val res = Array(r) { IntArray(c) }

    if (nums.isEmpty() || r * c != nums.size * nums[0].size) return nums

    var count = 0
    for (i in nums.indices) {
        for (j in nums[0].indices) {
            res[count / c][count % c] = nums[i][j]
            count++
        }
    }
    return res
}