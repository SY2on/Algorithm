import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

class Top(height:Int,index:Int){
    val height = height
    val index = index
}

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val inputSize = br.readLine().toInt()
    val token = StringTokenizer(br.readLine())
    var result = MutableList<Int>(inputSize){0}
    var builder = StringBuilder()
    var topList = ArrayList<Top>()
    var tmp = Stack<Top>()

    for(i in 1..inputSize){
        topList.add(Top(token.nextToken().toInt(), i))
    }
    for(i in inputSize-1 downTo 0){
        while(!tmp.empty()&&tmp.peek().height<topList[i].height){
            val fromTop = tmp.pop()
            result[fromTop.index-1]=topList[i].index
        }
        tmp.push(topList[i])
    }

    result.forEach{i->builder.append(i).append(" ")}
    bw.write(builder.toString())
    bw.close()
}