package de.mosmann.peng

/**
 * ---------------
 * |             |
 * |             |
 * |             |
 * |             |
 * |             |
 * ---------------
 *
 * ###
 * ###
 * ###
 *
 *  |-
 * ---
 *  |
 *
 *
 */
class OurFirstMaze(val rows: List<Row>, val columns: Int) {
    enum class Field(val char: Char) {
        Free(' '),
        Corner('+'),
        HorizontalWall('-'),
        VerticalWall('|')
    }

    override fun toString(): String {
        return "Maze(${rows.size}x$columns)->\n"+
                rows.joinToString(separator = "\n",prefix = "", postfix = "")
    }

    fun whatIsAt(position: MazePosition): Field {
        val row = rows[position.row]
        return row.columns[position.column]
    }

    fun canIWalkTo(position: MazePosition, direction: Direction): Boolean {
        val field = whatIsAt(position.nextPositionInto(direction))

        return field == Field.Free
    }

    class Row(val columns: List<Field>) {
        override fun toString(): String {
            return columns.map { it.char }.joinToString(separator = "")
        }
    }

    companion object {
        fun create(fieldAsString: String): OurFirstMaze {
            val rows: List<String> = fieldAsString.split('\n')
            val lens = rows.map { row -> row.length }
            val columns = lens.maxOf { it }

            lens.forEach {
                require(it==columns) {"zeile hat die falsche länge: $it"}
            }

            val mappedRows = rows.map { row -> Row(fieldsOfRow(row)) }
            return OurFirstMaze(mappedRows, columns)
        }

        fun fieldsOfRow(row: String): List<Field> {
            val ret = row.map { fieldFromChar(it) }
            return ret
        }

        fun fieldFromChar(char: Char): Field {
            val match: Field? = Field.values().find { it.char==char }
            if (match!=null) {
                return match
            }
            throw IllegalArgumentException("could not find matching field type: $char")
        }
    }
}