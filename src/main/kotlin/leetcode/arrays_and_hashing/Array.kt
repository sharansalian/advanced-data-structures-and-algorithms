package leetcode.arrays_and_hashing

fun main() {
    val a = intArrayOf(3, 6, 9, 1)

    for (i in 0 until a.size - 1) {
        println("${a[i+1]}")
    }
}


internal class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSubarray = Int.MIN_VALUE

        for (i in nums.indices) {
            var currentSubarray = 0
            for (j in i until nums.size) {
                currentSubarray += nums[j]
                maxSubarray = Math.max(maxSubarray, currentSubarray)
            }
        }

        return maxSubarray
    }
}