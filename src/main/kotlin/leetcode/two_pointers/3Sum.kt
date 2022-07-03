package leetcode.two_pointers

fun main() {

    val s = "ABAB"
    characterReplacement(s, 2)
}

fun characterReplacement(s: String, k: Int): Int {
    val map = hashMapOf<Char, Int>()
    var res = 0
    var l = 0
    var maxf = 0
    for ( r in 0 until s.length){
        map[s[r]] = 1 + map.getOrDefault(s[r], 0)
        maxf = Math.max(maxf, map[s[r]] ?: 0)

        while(((r-l+1) - maxf) > k){
            map[s[l]] = map.getOrDefault(s[r], 0) - 1
            l++
        }
        res = Math.max(res, r -l +1)
    }
    return res

}