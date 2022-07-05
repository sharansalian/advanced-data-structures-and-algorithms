package leetcode.arrays_and_hashing


class Codec {

    fun encode(strs: List<String>): String {
        var res = ""
        for (s in strs) {
            res += "${s.length}#$s"
        }

        return res
    }

    fun decode(str: String): List<String> {
        val res = mutableListOf<String>()
        var i = 0

        while (i < str.length) {
            var j = i
            var length = ""
            while (str[j] != '#') {
                length +=str[j]
                j++

            }
            val wordLength = length.toInt()
            res.add(str.slice(j + 1 until j + 1 + wordLength))
            i = j + 1 + wordLength
        }

        return res
    }
}

fun main() {
    val code = Codec()

    val str = code.encode(listOf("63/Rc", "h", "BmI3FS~J9#vmk", "7uBZ?7*/", "24h+X", "O "))
    val strs = code.decode(str)
    for (s in strs) {
        println(s)
    }
}