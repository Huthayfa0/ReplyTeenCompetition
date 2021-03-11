package Competition2021

import java.io.File
import java.util.Collections.min
import kotlin.math.sqrt

fun main() {
    val inputStream = File("src/Competition2021/AInput/A.in").inputStream().bufferedReader()
    val t=inputStream.readLine()!!.toInt()
    val pr=File("src/Competition2021/Aoutput/A.txt").printWriter()
    repeat(t){
        val n=inputStream.readLine()!!.toInt()
        val arr=inputStream.readLine()!!.split(' ').map { it.toInt() }
        val gcd=findGCD(arr,n)
        val ans=primeSum(gcd)

        pr.println("Case #${it+1}: $ans")
    }
    pr.close()
}

fun primeSum(num: Int): Int {
    var n=num
    var x=0
    var ans=1
    while (n % 2 == 0) {
        x++
        n /= 2
    }
    ans+=ans*x
        var i = 3
        while (i <= sqrt(n.toDouble())) {
            x=0
            // While i divides n, print i and divide n
            while (n % i == 0) {
                x++
                n /= i
            }
            i += 2
            ans+=ans*x
        }
    x=0
    if (n > 2) x++
    ans+=ans*x
    return ans
}

fun gcd(a: Int, b: Int): Int = if (a == 0) b else gcd(b % a, a)

fun findGCD(arr: List<Int>, n: Int): Int {
    var result = arr[0]
    for (i in 1 until n) {
        result = gcd(arr[i], result)
        if (result == 1) {
            return 1
        }
    }
    return result
}