package smile.surya.aoc2021.solution

import smile.surya.aoc2021.template.Solution
import smile.surya.aoc2021.util.binaryToDecimal
import smile.surya.aoc2021.util.bitFlip
import smile.surya.aoc2021.util.splitMultiLine

/**
 * Binary Diagnostic
 * https://adventofcode.com/2021/day/3
 * */

class Day3 : Solution() {

    override fun solvePart1(input: String): Any {
        val rows: List<List<Int>> = input.toBitString()

        val mostCommonBits: List<Int> = rows.first().indices.map { findMostCommonBit(rows, it) }
        val leastCommonBits: List<Int> = mostCommonBits.map { it.bitFlip() }

        val gammaRate: Int = mostCommonBits.binaryToDecimal()
        val epsilonRate: Int = leastCommonBits.binaryToDecimal()

        return gammaRate * epsilonRate
    }

    override fun solvePart2(input: String): Any {
        return ""
    }

    private fun String.toBitString() =
        splitMultiLine()
            .map { row ->
                row.split("")
                    .filter { it.isNotBlank() }
                    .map { it.toInt() }
            }

    private fun findMostCommonBit(rows: List<List<Int>>, column: Int, equallyCommonDefault: Int = 1): Int {
        val meanBit: Double = rows.sumOf { it[column] } / rows.count().toDouble()
        return if (meanBit == 0.5) equallyCommonDefault else if (meanBit > 0.5) 1 else 0
    }
}

fun main() {
    val day3 = Day3()
    day3.solve()
}