package adv_kotlin.functions


fun op(x: Int, op: (Int) -> Int): Int {
    return op(x)
}

fun main() {
    op(3) {
        if (it > 10)
            return@op it
        else {
            return@op it * it
        }
    }

    op(3, fun(x): Int { return x * x })
}