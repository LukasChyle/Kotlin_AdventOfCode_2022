import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.io.BufferedReader
import java.io.StringReader

internal class Aoc2022Day1Test {

    private val br: BufferedReader = BufferedReader(
        StringReader(
            "1000\n" +
                    "2000\n" +
                    "3000\n" +
                    "    \n" +
                    "2000\n" +
                    "4000\n" +
                    "1000\n" +
                    "2000\n" +
                    "    \n" +
                    "2000\n" +
                    "3000\n" +
                    "2000\n" +
                    "1000"
        )
    )

    @Test
    fun sortBackpacks() {
        val test = sortBackpacks(br)
        assertEquals(9000, test[0])
        assertEquals(8000, test[1])
        assertEquals(6000, test[2])

    }

    @Test
    fun sumBackpack() {
        val test = sumBackpack(br, 0)
        assertEquals(6000, test)
    }
}