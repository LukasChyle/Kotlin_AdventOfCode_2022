import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Aoc2022Day6Test {

    @Test
    fun findMarker() {
        val file = File("src/test/resources/TestFile_Aoc2022Day6").readLines().toList()
        val test1 = getMarker(file[0].toCharArray(), true)
        val test2 = getMarker(file[1].toCharArray(), true)
        val test3 = getMarker(file[2].toCharArray(), true)
        val test4 = getMarker(file[3].toCharArray(), true)
        val test5 = getMarker(file[4].toCharArray(), true)
        assertEquals(7, test1)
        assertEquals(5, test2)
        assertEquals(6, test3)
        assertEquals(10, test4)
        assertEquals(11, test5)
        val test6 = getMarker(file[0].toCharArray(), false)
        val test7 = getMarker(file[1].toCharArray(), false)
        val test8 = getMarker(file[2].toCharArray(), false)
        val test9 = getMarker(file[3].toCharArray(), false)
        val test10 = getMarker(file[4].toCharArray(), false)
        assertEquals(19, test6)
        assertEquals(23, test7)
        assertEquals(23, test8)
        assertEquals(29, test9)
        assertEquals(26, test10)
    }
}