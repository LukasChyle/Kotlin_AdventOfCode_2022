import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Aoc2022Day4Test {

    @Test
    fun sumOverlaps() {
        val testPart1 = sumOverlaps(File("src/test/resources/TestFile_Aoc2022Day4"), true)
        assertEquals(2, testPart1)
        val testPart2 = sumOverlaps(File("src/test/resources/TestFile_Aoc2022Day4"), false)
        assertEquals(4, testPart2)
    }

    @Test
    fun checkIfFullOverlap() {
        val test1 = checkIfFullOverlap(intArrayOf(2,6,4,8)) // 2-6,4-8
        val test2 = checkIfFullOverlap(intArrayOf(2,8,3,7)) // 2-8,3-7
        assertEquals(0, test1)
        assertEquals(1, test2)
    }

    @Test
    fun checkIfOverlap() {
        val test1 = checkIfOverlap(intArrayOf(2,4,6,8)) // 2-4,6-8
        val test2 = checkIfOverlap(intArrayOf(2,6,4,8)) // 2-6,4-8
        val test3 = checkIfOverlap(intArrayOf(2,8,3,7)) // 2-8,3-7
        assertEquals(0, test1)
        assertEquals(1, test2)
        assertEquals(1, test3)
    }
}