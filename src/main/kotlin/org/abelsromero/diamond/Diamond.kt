package org.abelsromero.diamond

class Diamond(size: Int) {

    private val size = if (size == 0 || (size > 0 && size % 2 != 0))
        size
    else
        if (size < 0)
            throw IllegalArgumentException("Size must be odd positive number")
        else
            throw IllegalArgumentException("Size must be odd number")


    companion object {
        private val STAR = '*'
        private val SPACE = "_"
    }

    fun build(): String {
        return when (size) {
            0 -> ""
            1 -> "*"
            else -> buildLines()
        }
    }

    private fun buildLines(): String {
        return (1..size).map {
            buildLine(it, STAR)
        }.joinToString(separator = "\n")
    }

    fun buildLine(index: Int, c: Char): String {
        val half = size.div(2)
        return if (index == 1 || index == size) {
            SPACE.repeat(half) + c + SPACE.repeat(half)
        } else if (index <= half) {
            val first = SPACE.repeat(half - (index - 1)) + c + SPACE.repeat(index - 2)
            "$first$SPACE${first.reversed()}"
        } else if (index == half + 1) {
            c + SPACE.repeat(size - 2) + c
        } else {
            // if (index > half + 1)
            buildLine(size - index + 1, c)
        }
    }

}
