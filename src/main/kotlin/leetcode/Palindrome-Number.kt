package leetcode

import java.util.*

fun main() {
    print(isPalindrome("A man, a plan, a canal: Panama"))
}

fun isPalindrome(str: String): Boolean {
    var newStr = " "

    for (c in str) {
        if (c.isLetter()) {
            newStr += c.lowercase()
        }
    }
    return newStr == newStr.reversed()
}

fun isPalindromeT(s: String): Boolean {
    var content = StringBuilder()
    for (i in 0 until s.length) if (Character.isLetterOrDigit(s[i])) content.append(s[i])
    content = StringBuilder(content.toString().replace(" ", "").lowercase(Locale.getDefault()))
    val value = content.toString()
    return value == content.reverse().toString()
}

class SolutionX {
    val re = Regex("[^A-Za-z0-9]")
    fun isPalindrome(s: String): Boolean {
        val cleanString = re.replace(s, "").toLowerCase()
        return if (cleanString == cleanString.reversed()) true else false
    }
}