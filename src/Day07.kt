import kotlin.math.roundToInt

fun main() {
    // median
    fun part1(input: List<String>): Int {
        val crabPositions = getIntList(input.first().split(","))
        val sortedPositions = crabPositions.sorted()

        // if number is odd we just take the middle index of a sorted list
        val median = if (sortedPositions.size % 2 == 1) {
            val medianIndex = sortedPositions.size / 2 // works because of truncation
            sortedPositions[medianIndex]
        } else {
            val medianIndex = sortedPositions.size / 2
            ((sortedPositions[medianIndex] + sortedPositions[medianIndex - 1]).toDouble() / 2).roundToInt() // get average of middle
        }

        // count distance from median for each value
        var count = 0
        sortedPositions.forEach {
            count += kotlin.math.abs(it - median)
        }

        return count
    }

    // mean
    fun part2(input: List<String>): Long {
        val crabPositions = getIntList(input.first().split(","))
        val average = crabPositions.average().toInt()

        // count distance from median for each value
        var count: Long = 0
        crabPositions.forEach {
            val distance = kotlin.math.abs(it - average) + 1 // add one to get the sum of a number and all below it
            val sumOfValAndBelow = ((distance * (distance - 1)) / 2)
            count += sumOfValAndBelow // the sum of a number and all ints below it
        }
        println(count)

        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test")
    check(part1(testInput) == 37)
    // check(part2(testInput) == (168).toLong())

    // print solutions
    val input = readInput("Day07")
    println(part1(input))
    println(part2(input))
}
