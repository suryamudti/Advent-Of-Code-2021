package smile.surya.aoc2021.solution

import smile.surya.aoc2021.template.Solution
import smile.surya.aoc2021.util.splitMultiLine

/**
 * Dive !
 * https://adventofcode.com/2021/day/2
 * */

class Day2 : Solution() {

    override fun solvePart1(input: String): Any {
        val lines = input.splitMultiLine()
        var horizontalPosition = 0
        var depth = 0
        lines.forEach {
            val value = getValue(it)
            if (it.startsWith("forward"))
                horizontalPosition += value
            else if (it.startsWith("up"))
                depth -= value
            else if (it.startsWith("down"))
                depth += value
        }
        return horizontalPosition * depth
    }

    override fun solvePart2(input: String): Any {
        return ""
    }

    private fun getValue(command: String) = command.split(" ")[1].toInt()
}

fun main() {
    val day2 = Day2()
    day2.solve()
}