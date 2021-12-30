package smile.surya.aoc2021.solution

import smile.surya.aoc2021.template.Solution

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
        return countIncreases(measurements)
    }

    private fun countIncreases(values: List<Int>): Int {
        var counter = 0
        var prevValue: Int = 0
        values.forEach {
            if (it > prevValue) counter++
            prevValue = it
        }
        return counter
    }

    private fun String.splitMultiLine(): List<String> {
        return split("\n")
    }

}

fun main() {
    val day1 = Day1()
    day1.solve()
}