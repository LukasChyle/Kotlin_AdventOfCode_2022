import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Aoc2022Day3Test {

    @Test
    fun getPriorities() {
        val test = getPriorities(charArrayOf('p', 'L', 'P' , 'v', 't', 's'))
        assertEquals(157, test)
    }

    @Test
    fun calcPart1() {
        val test = calcPart1(File("src/test/resources/TestFile_Aoc2022Day3"))
        assertEquals(157, test)
    }

    @Test
    fun calcPart2() {
        val test = calcPart2(File("src/test/resources/TestFile_Aoc2022Day3"))
        assertEquals(70, test)
    }
}