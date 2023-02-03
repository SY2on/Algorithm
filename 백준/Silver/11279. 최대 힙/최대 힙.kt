import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var builder = StringBuilder()

    val num = br.readLine().toInt()
    val input = ArrayList<Int>()
    var queue = PriorityQueue<Int>(Collections.reverseOrder())
    repeat(num){
        input.add(br.readLine().toInt())
    }
    for(i in input.indices){
        if(input[i]==0){
            if(queue.isEmpty()){
                builder.append(0).append('\n')
            }else{
                builder.append(queue.poll()).append('\n')
            }
        }else{
            queue.add(input[i])
        }
    }

    bw.write(builder.toString())
    bw.close()
}