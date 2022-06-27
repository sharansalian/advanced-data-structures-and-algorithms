package leetcode.sliding_window

import kotlin.math.max


fun lengthOfLongestSubstring(s: String): Int {
    val set = hashSetOf<Char>()
    var l = 0
    var res = 0
    for ( r in 0  until s.length){
        while(s[r] in set){
            set.remove(s[l])
            l += 1
        }
        set.add(s[r])
        res = Math.max(res, r - l + 1)
    }

    return res
}

fun main() {
    val s = "pwwkew"
    println(lengthOfLongestSubstring(s))
}