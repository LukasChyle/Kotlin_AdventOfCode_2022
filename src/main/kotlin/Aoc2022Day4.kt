import java.io.File

fun main() {
    println("Part 1 v1 :${sumOverlaps(File("src/main/resources/2022_04_Assignments"), true)}")
    println("Part 2 v1 :${sumOverlaps(File("src/main/resources/2022_04_Assignments"), false)}")

    getOverlaps() // version 2
}

/* ----------------- VERSION 1 ----------------- */
fun sumOverlaps(f: File, fullOverlap: Boolean): Int {
    val list: List<IntArray> = f.readLines().map {
        it.split('-', ',').map { s -> s.toInt() }.toIntArray()
    }
    if (fullOverlap){
        return list.sumOf { checkIfFullOverlap(it) }
    }
    return list.sumOf { checkIfOverlap(it) }
}

fun checkIfFullOverlap(i: IntArray): Int {
    if ((i[2] >= i[0] && i[3] <= i[1]) || (i[2] <= i[0] && i[3] >= i[1]))  return 1
    return 0
}

fun checkIfOverlap(i: IntArray): Int {
    if ((i[2] >= i[0] && i[3] <= i[1]) || (i[2] <= i[0] && i[3] >= i[1]) ||
        (i[2] <= i[0] && i[3] >= i[0]) || (i[2] <= i[1] && i[3] >= i[1])) return 1
    return 0
}

/* ----------------- VERSION 2 ----------------- */
fun splitToRange(input: String): IntRange {
    val (start, end) = input.split("-").map { s -> s.toInt()}
    return start..end
}

fun getOverlaps() {
    println("Part 1 v2 :${File("src/main/resources/2022_04_Assignments").readLines().count {
        val (string1, string2) = it.split(",")
        val range1 = splitToRange(string1)
        val range2 = splitToRange(string2)
        range1.all { r1 -> range2.contains(r1) } || range2.all { r2 -> range1.contains(r2) }}}")

    println("Part 2 v2 :${File("src/main/resources/2022_04_Assignments").readLines().count {
        val (string1, string2) = it.split(",")
        val range1 = splitToRange(string1)
        val range2 = splitToRange(string2)
        range1.any { r1 -> range2.contains(r1) } || range2.any { r2 -> range1.contains(r2) }}}")
}