package adv_kotlin.functions

import kotlin.text.StringBuilder

class Time(val hours: Int, val minutes: Int) {

    operator fun plus(time: Time): Time {
        val minutes = this.minutes + time.minutes
        return Time(1, minutes)
    }
}

operator fun StringBuilder.plus(sb: StringBuilder) {
    sb.forEach { this.append(it) }
}

fun main() {
    val time = Time(10, 40) + Time(10, 30)

    val sb = StringBuilder()
    sb.append("Valhala")
    for (s in sb){
        s + "$"
    }
}