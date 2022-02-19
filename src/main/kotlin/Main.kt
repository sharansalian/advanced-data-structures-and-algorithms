fun main(args: Array<String>) {
    println("Hello World!")
    multiplicationBoard(3)

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

fun multiplicationBoard(size: Int) {
    for (number in 1..size) {
        print(" | ")
        for (otherNumber in 1..size) {
            print(" $number x $otherNumber = ${number * otherNumber} | ")
        }
        println()
    }
}