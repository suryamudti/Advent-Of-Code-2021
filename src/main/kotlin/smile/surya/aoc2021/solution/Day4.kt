package smile.surya.aoc2021.solution

import smile.surya.aoc2021.template.Solution
import smile.surya.aoc2021.util.transpose

class Day4 : Solution() {
    override fun solvePart1(input: String): Any {
        val lines = input.split("\n\n")
        val numberDrawer = lines.first().split(",").map { it.toInt() }.listIterator()
        val boards = parseBoards(lines)

        while (numberDrawer.hasNext()) {
            val drawnNumber = numberDrawer.next()

            val winnerGrouping: Map<Boolean, List<BingoBoard>> = boards.groupBy { it.markNumber(drawnNumber) }
        }

        return lines
    }

    override fun solvePart2(input: String): Any {
        TODO("Not yet implemented")
    }

    private fun parseBoards(boards: List<String>): Collection<BingoBoard> {
        return boards.map { board ->
            BingoBoard(
                board.split("\n").map { row ->
                    row.split(" ").filter { it.isNotBlank() }.map { it.toInt() }
                }
            )
        }
    }

    class BingoBoard(grid: List<List<Int>>) {
        private val board: List<List<Cell>> = grid.map { it.map { Cell(it) } }
        private val transposeBoard: List<List<Cell>> = board.transpose()
        private val numbersMap: Map<Int, Cell> = board.flatten().associateBy { it.value }

        operator fun contains(value: Int): Boolean = numbersMap.containsKey(value)

        fun markNumber(number: Int): Boolean {
            if (number !in this) {
                return false
            }
            numbersMap[number]!!.mark()
            return checkIfWon()
        }

        private fun checkIfWon(): Boolean {
            return (board.asSequence().map { row -> row.all { it.isMarked } }.any { it }
                    || transposeBoard.asSequence().map { column -> column.all { it.isMarked } }.any { it })
        }

        private data class Cell(
            val value: Int,
            var isMarked: Boolean = false
        ) {
            fun mark() {
                isMarked = true
            }
        }
    }
}

fun main() {
   val day4 = Day4()
   day4.solve()
}

