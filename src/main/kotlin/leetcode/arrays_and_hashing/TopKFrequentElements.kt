package leetcode.arrays_and_hashing

fun main() {
    println(topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).contentToString())
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val count = hashMapOf<Int, Int>()
    val freq = MutableList<MutableList<Int>>(nums.size + 1) { mutableListOf() }
    for (n in nums) {
        count[n] = count.getOrDefault(n, 0) + 1
    }

    for ((n, c) in count) {
        freq[c].add(n)
    }

    val res = mutableListOf<Int>()

    for (i in freq.size - 1 downTo 0) {
        for (n in freq[i]) {
            res.add(n)
            if (res.size == k) {
                return res.toIntArray()
            }
        }
    }

    return res.toIntArray()
}