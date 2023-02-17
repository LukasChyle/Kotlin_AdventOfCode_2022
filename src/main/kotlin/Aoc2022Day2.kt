import java.io.File

fun main() {
    println("Part 1 v1: ${File("src/main/resources/2022_02_StrategyGuide")
            .readLines().sumOf { calculateRound(it, false) }}")

    println("Part 2 v1: ${File("src/main/resources/2022_02_StrategyGuide")
            .readLines().sumOf { calculateRound(it, true) }}")

    getScore() // version 2
}

/* ----------------- VERSION 1 ----------------- */
fun calculateRound(s: String, part2: Boolean): Int {
    val c = s.replace(" ", "").toCharArray()

    if (part2) {
        c[1] = if ((c[1] == 'X' && c[0] == 'B') || (c[1] == 'Y' && c[0] == 'A') || (c[1] == 'Z' && c[0] == 'C')) {
            'X'
        } else if ((c[1] == 'X' && c[0] == 'C') || (c[1] == 'Y' && c[0] == 'B') || (c[1] == 'Z' && c[0] == 'A')) {
            'Y'
        } else {
            'Z'
        }
    }

    val choice = when (c[1]) {
        'X' -> 1
        'Y' -> 2
        'Z' -> 3
        else -> 0
    }
    val result = if ((c[1] == 'X' && c[0] == 'A') || (c[1] == 'Y' && c[0] == 'B') || (c[1] == 'Z' && c[0] == 'C')) {
        3
    } else if ((c[1] == 'X' && c[0] == 'C') || (c[1] == 'Y' && c[0] == 'A') || (c[1] == 'Z' && c[0] == 'B')) {
        6
    } else {
        0
    }
    return choice + result
}

/* ----------------- VERSION 2 ----------------- */
fun getScore() {
    println("Part 1 v2: ${File("src/main/resources/2022_02_StrategyGuide").readLines().sumOf { 
        mapOf(
            "A X" to 4,
            "A Y" to 8,
            "A Z" to 3,
            "B X" to 1,
            "B Y" to 5,
            "B Z" to 9,
            "C X" to 7,
            "C Y" to 2,
            "C Z" to 6,
        ).getValue(it) }}")

    println("Part 2 v2: ${File("src/main/resources/2022_02_StrategyGuide").readLines().sumOf {
        mapOf(
            "A X" to 3,
            "A Y" to 4,
            "A Z" to 8,
            "B X" to 1,
            "B Y" to 5,
            "B Z" to 9,
            "C X" to 2,
            "C Y" to 6,
            "C Z" to 7,
        ).getValue(it) }}")
}