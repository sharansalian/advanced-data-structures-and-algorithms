package problems

/**
 * Find frequencies of all duplicates elements in the array
 *      Input: arr[] = {2, 3, 4, 5, 4, 6, 4, 7, 4, 5, 6, 6}
 *      Output:
 *      Below is the frequency of repeated elements –
 *      4 –> 4
 *      5 –> 2
 *      6 –> 3
 *
 *
 *      Input: arr[] = {4, 4, 5, 5, 6}
 *      Output: Below is the frequency of repeated elements –
 *      4 –> 2
 *      5 –> 2
 *
 *
 * */

object Solution {

    fun findRepeating(arr: List<Int>) : HashMap<Int, Int> {
        val frequency: HashMap<Int, Int> = hashMapOf()

        for (i in arr){
            if(frequency.containsKey(i)){
                frequency[i] = frequency[i]?.plus(1) ?: 0
            } else {
                frequency[i] = 1
            }
        }
        return frequency
    }
}


fun main() {

    val arr = listOf(2, 3, 4, 5, 4, 6, 4, 7, 4, 5, 6, 6)
    val frequency = Solution.findRepeating(arr)

    println("Below is the frequency of repeated elements")

    frequency.forEach { (key, value) ->
        println("$key --> $value")
    }


}