import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

fun getIntList(stringList: List<String>): List<Int> {
    val intList = mutableListOf<Int>()
    stringList.forEach {
        intList.add(it.toInt())
    }

    return intList
}

// helpers
fun sumVals(valList: List<Int>): Int {
    var total = 0
    valList.forEach {
        total += it
    }

    return total
}

// helpers
fun sumValsString(valList: List<String>): Int {
    val intList = mutableListOf<Int>()

    valList.forEach {
        intList.add(it.toInt())
    }

    return sumVals(intList)
}

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
