import java.io.BufferedReader
import java.io.File

fun main() {
    val calorieFile = File("src/main/resources/2022_01_CalorieList").bufferedReader()
    val sortedList = sortBackpacks(calorieFile)
    println("Part 1 v1: ${sortedList[0]}")
    println("Part 2 v1: ${sortedList[0] + sortedList[1] + sortedList[2]}")

    getCalories() // version 2
}

/* ----------------- VERSION 1 ----------------- */
fun sortBackpacks(br: BufferedReader): MutableList<Int> {
    val backpacks: MutableList<Int> = arrayListOf()
    while (true) {
        val line = br.readLine() ?: break
        if (line.isNotBlank()) {
            backpacks.add(sumBackpack(br, line.toInt()))
        }
    }
    backpacks.sortDescending()
    return backpacks
}

fun sumBackpack(br: BufferedReader, i: Int): Int {
    val line = br.readLine() ?: return i
    return if (line.isNotBlank()) {
        sumBackpack(br, i + line.toInt())
    } else {
        i
    }
}

/* ----------------- VERSION 2 ----------------- */
fun getCalories() {
    val sums = File("src/main/resources/2022_01_CalorieList").readText().split("\n\r")
        .map { it.lines().filter { s -> s.isNotBlank() }.sumOf(String::toInt) }.sortedDescending()

    println("Part 1 v2: ${sums.first()}")
    println("Part 2 v2: ${sums.take(3).sum()}")
}