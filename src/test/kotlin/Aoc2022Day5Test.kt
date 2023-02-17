import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Aoc2022Day5Test {

    @Test
    fun processDocument() {
        val testPart1 = processDocument(File("src/test/resources/TestFile_Aoc2022Day5"), true)
        assertEquals("CMZ", testPart1)
        val testPart2 = processDocument(File("src/test/resources/TestFile_Aoc2022Day5"), false)
        assertEquals("MCD", testPart2)
    }

    @Test
    fun getDrawing() {
        val list: List<String> = listOf("    [D]    ", "[N] [C]    ", "[Z] [M] [P]", " 1   2   3 ")
        val test = getDrawing(list)
        assertEquals(listOf('N', 'Z'), test[0])
        assertEquals(listOf('D', 'C', 'M'), test[1])
        assertEquals(listOf('P'), test[2])
        assertEquals(3, test.size)
    }

    @Test
    fun processDrawing() {
        val list: List<String> =
            listOf("move 1 from 2 to 1", "move 3 from 1 to 3", "move 2 from 2 to 1" ,"move 1 from 1 to 2")

        val drawing: List<MutableList<Char>> =
            listOf(
                mutableListOf('N', 'Z'),
                mutableListOf('D', 'C', 'M'),
                mutableListOf('P')
            )
        val drawing2: List<MutableList<Char>> =
            listOf(
                mutableListOf('N', 'Z'),
                mutableListOf('D', 'C', 'M'),
                mutableListOf('P')
            )

        val test1 = processDrawing(drawing, list, true)
        assertEquals("CMZ", test1)
        val test2 = processDrawing(drawing2, list, false)
        assertEquals("MCD", test2)
    }
}