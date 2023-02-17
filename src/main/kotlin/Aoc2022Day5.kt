import java.io.File

fun main() {
    println("Part 1 v1 :${processDocument(File("src/main/resources/2022_05_Info"), true)}")
    println("Part 2 v1 :${processDocument(File("src/main/resources/2022_05_Info"), false)}")

    println("Part 1 v2 :${getTopContainers(true)}")
    println("Part 2 v2 :${getTopContainers(false)}")
}

/* ----------------- VERSION 1 ----------------- */
fun processDocument(f: File, part1: Boolean): String {
    val list = f.readLines().toList()
    return processDrawing(getDrawing(list), list, part1)
}

fun getDrawing(list: List<String>): List<MutableList<Char>> {
    val drawing: List<MutableList<Char>> =
        List(list.first { it.elementAt(1) == '1' }.reversed().trim().first().digitToInt()) { mutableListOf() }

    list.forEach {
        if (it.elementAt(1) == '1') {
            return drawing
        }
        for (i in 0..list[0].length / 4) {
            if (it.elementAt(i * 4 + 1) != ' ') {
                drawing[i].add(it.elementAt(i * 4 + 1))
            }
        }
    }
    return drawing
}

fun processDrawing(drawing: List<MutableList<Char>>, list: List<String>, part1: Boolean): String {
    list.filter { it.contains("move") }.forEach {
        val move = it.substringAfter("ve ").substringBefore(" fr").toInt() - 1
        val from = it.substringAfter("om ").substringBefore(" to").toInt() - 1
        val to = it.substringAfter("to ").toInt() - 1
        for (i in move downTo 0) {
            if (part1) {
                drawing[to].add(0, drawing[from][0])
                drawing[from].removeAt(0)
            } else {
                drawing[to].add(0, drawing[from][i])
                drawing[from].removeAt(i)
            }
        }
    }
    return drawing.joinToString { it[0].toString() }.replace(", ", "")
}

/* ----------------- VERSION 2 ----------------- */
fun getTopContainers(part1: Boolean): String {
    val s = File("src/main/resources/2022_05_Info").readText()

    val stacks: List<MutableList<Char>> =
        List(s.lines().first { it[1] == '1' }.reversed().trim().first().digitToInt()) { mutableListOf() }

    s.lines().filter { it.contains('[') }.forEach {
        for (i in stacks.indices) {
            if (it.elementAt(i * 4 + 1) != ' ') {
                stacks[i].add(it.elementAt(i * 4 + 1))
            }
        }
    }
    s.lines().filter { it.contains("move") }.map { it.split(" ").toList() }.map { i ->
        val toBeMoved = stacks[i[3].toInt() - 1].take(i[1].toInt())
        repeat(i[1].toInt()) { stacks[i[3].toInt() - 1].removeFirst() }
        stacks[i[5].toInt() - 1].addAll(0, if (part1) toBeMoved.reversed() else toBeMoved)
    }
    return stacks.joinToString { it[0].toString() }.replace(", ", "")
}






