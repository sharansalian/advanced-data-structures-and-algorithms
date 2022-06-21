package adv_kotlin.classes

class Log() {

    companion object {

        @JvmStatic
        fun createFileLog(fileName: String) {

        }
    }
}

fun main() {
    val log = Log()

    val fileLog = Log.createFileLog("xxx.txt")
}