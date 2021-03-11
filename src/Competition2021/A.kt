package Competition2021

import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("src/Competition2021/AInput/a.in").inputStream()
    val line=inputStream.bufferedReader().readLine()!!.split(' ')
    println(line)
}