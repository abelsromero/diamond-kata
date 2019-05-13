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
        private val STAR = "*"
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
            buildLine(it)
        }.joinToString(separator = "\n")
    }

    private fun buildLine(index: Int): String {
        val half = size.div(2)
        return if (index == 1 || index == size) {
            SPACE.repeat(half) + STAR + SPACE.repeat(half)
        } else if (index <= half) {
            val first = SPACE.repeat(half - (index - 1)) + STAR + SPACE.repeat(half - 1 - (half - (index - 1)))
            "$first$SPACE${first.reversed()}"
        } else if (index == half + 1) {
            STAR + SPACE.repeat(size - 2) + STAR
        } else {
            // if (index > half + 1)
            buildLine(size - index +1)
        }
    }

}
