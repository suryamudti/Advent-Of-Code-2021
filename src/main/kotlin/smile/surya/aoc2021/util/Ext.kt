package smile.surya.aoc2021.util

fun String.splitMultiLine() = split("\n")

fun List<Int>.binaryToDecimal(): Int {
    require(this.all { it == 0 || it == 1 }) { "Expected bit string, but received $this" }
    return Integer.parseInt(this.joinToString(""), 2)
}

fun Int.bitFlip(): Int {
    require(this == 0 || this == 1) {
        "Expected bit, but received $this"
    }
    return this.xor(1)
}

fun String.toBitString() =
    splitMultiLine()
        .map { row ->
            row.split("")
                .filter { it.isNotBlank() }
                .map { it.toInt() }
        }