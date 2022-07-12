package leetcode.matrix


fun operateOnMatrix(matrix: Array<IntArray>) {

    for (a in matrix){
        println(a.contentToString())
    }

}

fun main() {

    val matrix = Array(3) { r -> IntArray(3) { c ->

        println("Row $r ---- Column $c")
        r + c } }
    operateOnMatrix(matrix)
}