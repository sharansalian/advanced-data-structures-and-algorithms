package leetcode.arrays_and_hashing

fun main() {

    println(productExceptSelf(intArrayOf(0, 0)).contentToString())
}

fun productExceptSelf(nums: IntArray): IntArray {
    val res = IntArray(nums.size)
    val map = hashMapOf<Int, Int>()

    for (i in 0 until nums.size) {
        map[i] = nums[i]
    }

    for (i in 0 until nums.size) {
        val others = map.filter { it.key != i }.map {
            it.value
        }.reduce { acc, i -> acc * i }
        res[i] = others
    }

    return res
}