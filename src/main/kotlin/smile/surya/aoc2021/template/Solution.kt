package smile.surya.aoc2021.template

import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

abstract class Solution {
    abstract fun solvePart1(input: String): Any

    abstract fun solvePart2(input: String): Any

    private val identifier: String = getClassName()

    fun solve() {
        val input: String = retrieveInput()

        println("The answer solution for part 1: ${solvePart1(input)}")
        println("The answer Solution for part 2: ${solvePart2(input)}")
    }

    private fun retrieveInput(): String {
        val inputDirectoryPath: Path = Paths.get("").resolve(INPUT_PATH).toAbsolutePath()
        return File("$inputDirectoryPath/$identifier.$INPUT_FILE_EXTENSION").readText()
    }

    private fun getClassName(): String = this::class.simpleName.toString()

    companion object {
        const val INPUT_PATH = "src/main/resources/inputs"
        const val INPUT_FILE_EXTENSION = "txt"
    }
}