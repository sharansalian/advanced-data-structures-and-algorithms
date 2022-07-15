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


fun maxAbsValExpr(arr1: IntArray, arr2: IntArray): Int {
    var max1 = Int.MIN_VALUE
    var min1 = Int.MAX_VALUE
    var max2 = Int.MIN_VALUE
    var min2 = Int.MAX_VALUE
    var max3 = Int.MIN_VALUE
    var min3 = Int.MAX_VALUE
    var max4 = Int.MIN_VALUE
    var min4 = Int.MAX_VALUE
    var MaxA = 0
    var MaxB = 0

    for (i in arr1.indices) {

        //|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
//			i > j

//			case 1 arr1[i] > arr1[j] && arr2[i] > arr2[j]
        max1 = Math.max(arr1[i] + arr2[i] + i, max1)
        min1 = Math.min(arr1[i] + arr2[i] + i, min1)

//			case 2 arr1[i] > arr1[j] && arr2[i] < arr2[j]
        max2 = Math.max(arr1[i] - arr2[i] + i, max2)
        min2 = Math.min(arr1[i] - arr2[i] + i, min2)

//			case 3 arr1[i] < arr1[j] && arr2[i] > arr2[j]
        max3 = Math.max(arr2[i] - arr1[i] + i, max3)
        min3 = Math.min(arr2[i] - arr1[i] + i, min3)

//			case 4 arr1[i] < arr1[j] && arr2[i] < arr2[j]
        max4 = Math.max(i - arr1[i] - arr2[i], max4)
        min4 = Math.min(i - arr1[i] - arr2[i], min4)
    }
    MaxA = Math.max(max1 - min1, max2 - min2)
    MaxB = Math.max(max3 - min3, max4 - min4)
    return Math.max(MaxA, MaxB)
}