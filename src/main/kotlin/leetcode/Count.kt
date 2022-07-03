package leetcode

fun main() {

    frequencySort(intArrayOf(1,1,2,2,2,3))
}

fun frequencySort(nums: IntArray): IntArray {
    val count = hashMapOf<Int, Int>()
    val arr = IntArray(nums.size)
    for (n in nums) {
        count[n] = count.getOrDefault(n, 0) + 1
    }

    return nums.sortedWith(compareBy({ count[it]!! }, { -it })).toIntArray()

}