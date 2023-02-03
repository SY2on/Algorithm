import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())

    val N = token.nextToken().toInt()
    val M = token.nextToken().toInt()

    var set = HashSet<String>()
    repeat(N){
        set.add(br.readLine())
    }

    var count = 0
    repeat(M){
        val input = br.readLine()
        if(set.contains(input)){
            count++
        }
    }
    bw.write(count.toString())
    bw.close()
}