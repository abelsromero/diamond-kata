package org.abelsromero.diamond

class CharDiamond(val value: Char) {

    private val size = (value - 'A') * 2 + 1
    private val diamond = Diamond(size)

    fun build(): String {
        var rows = (1..size / 2).map { diamond.buildLine(it, 'A' + it - 1) }
        return (rows + diamond.buildLine(size / 2 + 1, value) + rows.reversed()).joinToString(separator = "\n")
    }

}
