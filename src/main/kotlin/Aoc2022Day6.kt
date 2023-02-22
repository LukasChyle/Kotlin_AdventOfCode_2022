import java.io.File

fun main() {
    println("Part 1: ${getMarker(
        File("src/main/resources/2022_06_Datastream").readText().toCharArray(),true)}")
    println("Part 2: ${getMarker(
        File("src/main/resources/2022_06_Datastream").readText().toCharArray(),false)}")

    println("Part 1 v2: ${
        File("src/main/resources/2022_06_Datastream").readText().findMarker(4)}")
    println("Part 2 v2: ${
        File("src/main/resources/2022_06_Datastream").readText().findMarker(14)}")
}

/* ----------------- VERSION 1 ----------------- */
fun getMarker(c: CharArray, part1 : Boolean): Int {
    val x = if (part1) 4 else 14
    for (i in x until c.size) {
        if (c.slice(i downTo i - (x - 1)).toSet().size == x) {
            return i + 1
        }
    }
    return -1
}

/* ----------------- VERSION 2 ----------------- */
private fun String.findMarker(markerSize: Int): Int =
    withIndex().windowed(markerSize, 1).first{
            w -> w.map { it.value }.toSet().size == markerSize
    }.last().index +1
