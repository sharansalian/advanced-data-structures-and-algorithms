package leetcode.arrays_and_hashing


fun main() {

    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val res = groupAnagrams(strs)
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {

    val res: HashMap<String, MutableList<String>> = hashMapOf() //char count TO list of anagrams


    for (s in strs) {
        val count = IntArray(26) // a .. z

        for (c in s) {
            val index = c - 'a'
            println("The index after substraction $index")
            count[index] += 1
        }

        res[count.joinToString()] = res.getOrDefault(count.joinToString(), mutableListOf()).also { it.add(s) }

    }

    val x: List<List<String>> = res.values.toList()

    return x
}

fun groupAnagramss(strs: Array<String>?): List<List<String?>>? {
    if (strs == null || strs.isEmpty()) return ArrayList()
    val map: MutableMap<String, MutableList<String?>> = HashMap()
    for (s in strs) {
        val ca = CharArray(26)
        for (c in s.toCharArray()) ca[c - 'a']++
        val keyStr = String(ca)
        if (!map.containsKey(keyStr)) map[keyStr] = ArrayList()
        map[keyStr]!!.add(s)
    }
    return ArrayList<List<String?>>(map.values)
}