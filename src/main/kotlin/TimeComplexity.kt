
fun sumFromOne(n: Int): Int {
    var result = 0
    for (i in 1..n) {
        result += i
    }
    return result
}

fun sum(n: Int): Int = (1..n).reduce { sum, element -> sum + element }

fun gauss(n: Int) = n * (n + 1) / 2

fun main() {
    println("The sum of 1 to 10 is: ${sumFromOne(10)}")
    println("The sum of 1 to 10 is: ${sum(10)}")
    println("The sum of 1 to 10 is: ${gauss(10)}")
}