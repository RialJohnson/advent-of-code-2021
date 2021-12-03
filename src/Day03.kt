fun main() {

    fun flipBinary(binaryString: String): String {
        val flippedBinary = java.lang.StringBuilder()

        binaryString.forEach {
            if (it == '0') flippedBinary.append('1') else flippedBinary.append('0')
        }

        return flippedBinary.toString()
    }

    fun getOxygenGenRating(input: List<String>): Int {
        var trimmedInput = input
        var index = 0

        while (trimmedInput.size > 1) {
            var zeroCount = 0
            var oneCount = 0
            var dominantBit = '1'

            // find out if 0 or 1 is dominant for this position
            trimmedInput.forEach {
                if (it[index] == '0') zeroCount++
                if (it[index] == '1') oneCount++
            }
            if (zeroCount > oneCount) dominantBit = '0'

            // only keep the strings that contain the dominant bit at this position
            trimmedInput = trimmedInput.filter {
                it[index] == dominantBit
            }

            index++
        }

        return Integer.parseInt(trimmedInput.first(), 2)
    }

    // basically the same as the oxygenGenRating but take the non-dominant bit
    fun getScrubberRating(input: List<String>): Int {
        var trimmedInput = input
        var index = 0

        while (trimmedInput.size > 1) {
            var zeroCount = 0
            var oneCount = 0
            var dominantBit = '0'

            // find out if 0 or 1 is dominant for this position
            trimmedInput.forEach {
                if (it[index] == '0') zeroCount++
                if (it[index] == '1') oneCount++
            }
            if (oneCount < zeroCount) dominantBit = '1'

            // only keep the strings that contain the dominant bit at this position
            trimmedInput = trimmedInput.filter {
                it[index] == dominantBit
            }

            index++
        }

        return Integer.parseInt(trimmedInput.first(), 2)
    }

    fun part1(input: List<String>): Int {
        val gammaRate: StringBuilder = java.lang.StringBuilder()
        val maxIndex = input.first().length - 1

        for (i in 0..maxIndex) {
            var zeroCount = 0
            var oneCount = 0
                input.forEach {
                    if (it[i] == '0') zeroCount++
                    if (it[i] == '1') oneCount++
                }
            if (zeroCount >= oneCount) gammaRate.append("0") else gammaRate.append("1")
        }

        val epsilonRate = flipBinary(gammaRate.toString())
        val gammaInt = Integer.parseInt(gammaRate.toString(), 2)
        val epsilonInt = Integer.parseInt(epsilonRate, 2)

        return gammaInt * epsilonInt
    }

    fun part2(input: List<String>): Int {

        val oxygenGenRating = getOxygenGenRating(input)
        val scrubberRating = getScrubberRating(input)

        return oxygenGenRating * scrubberRating
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    // print solutions
    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
