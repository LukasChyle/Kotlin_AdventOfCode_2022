import java.io.File

fun main() {
    println("Part 1 v1: ${ calcPart1(File("src/main/resources/2022_03_Contents")) }")
    println("Part 2 v1: ${ calcPart2(File("src/main/resources/2022_03_Contents")) }")

    sumPriorities() // version 2
}

/* ----------------- VERSION 1 ----------------- */
fun getPriorities(matches: CharArray): Int {
    return matches.sumOf { (listOf(('a'..'z') + ('A'..'Z')).flatten()).indexOf(it) + 1 }
}

fun calcPart1(f: File): Int {
    return f.readLines().sumOf { s ->
        getPriorities(
            (s.substring(0, s.length / 2).toCharArray()).filter {
                (s.substring(s.length / 2).toCharArray()).contains(it)
            }.distinct().toCharArray()
        )
    }
}

fun calcPart2(f: File): Int {
    val list: List<CharArray> = f.readLines().map { it.toCharArray() }
    var sum = 0
    for (i in list.indices step 3) {
        sum += getPriorities(list[i].filter {
            list[i + 1].contains(it) && list[i + 2].contains(it)
        }.distinct().toCharArray())
    }
    return sum
}

/* ----------------- VERSION 2 ----------------- */
fun getPriority(c: Char): Int {
    return (('a'..'z') + ('A'..'Z')).indexOf(c) + 1
}

fun sumPriorities() {
    println("Part 1 v2 :${File("src/main/resources/2022_03_Contents").readLines()
        .map { it.take(it.length / 2) to it.substring(it.length / 2) }
        .map { (it.first.toSet() intersect it.second.toSet()).single() }.sumOf { getPriority(it) }}")

    println("Part 2 v2 :${File("src/main/resources/2022_03_Contents").readLines()
        .map(String::toSet).chunked(3)
        .map { it.reduce(Set<Char>::intersect).single() }.sumOf{ getPriority(it) }}")
}