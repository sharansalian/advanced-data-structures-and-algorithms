package adv_kotlin.functions

class Time(val hours: Int, val minutes: Int) {

    operator fun plus(time: Time): Time {
        val minutes = this.minutes + time.minutes
        return Time(1, minutes)
    }
}

fun main() {
    val time = Time(10, 40) + Time(10, 30)
}