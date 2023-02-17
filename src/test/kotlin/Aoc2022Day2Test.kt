import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Aoc2022Day2Test {

    @Test
    fun calculateScore() {
        val test1 = calculateRound("A Y", false)
        val test2 = calculateRound("B X", false)
        val test3 = calculateRound("C Z", false)
        assertEquals(8, test1)
        assertEquals(1, test2)
        assertEquals(6, test3)

        val test4 = calculateRound("A Y", true)
        val test5 = calculateRound("B X", true)
        val test6 = calculateRound("C Z", true)
        assertEquals(4, test4)
        assertEquals(1, test5)
        assertEquals(7, test6)
    }
}