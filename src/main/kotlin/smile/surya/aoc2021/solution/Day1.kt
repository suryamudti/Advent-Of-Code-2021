package smile.surya.aoc2021.solution

import smile.surya.aoc2021.template.Solution
import smile.surya.aoc2021.util.splitMultiLine

/**
 *  Sonar Sweep
 *  https://adventofcode.com/2021/day/1
 * */

class Day1 : Solution() {

    override fun solvePart1(input: String): Any {
        val measurement: List<Int> = input.splitMultiLine().map {
            it.toInt()
        }
        return countIncreases(measurement)
    }

    override fun solvePart2(input: String): Any {
        val measurements: List<Int> = input.splitMultiLine().map {
            it.toInt()
        }
        val windows: List<Int> = measurements.windowed(3).map { it.sum() }
        return countIncreases(windows)
    }

    private fun countIncreases(values: List<Int>): Int {
        var counter = 0
        var prevValue: Int = Int.MAX_VALUE
        values.forEach {
            if (it > prevValue) counter++
            prevValue = it
        }
        return counter
    }



}

fun main() {
    val day1 = Day1()
    day1.solve()
}