import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*

//정수 x를 큐에 넣는다


//0으로 초기화한 큐
var queue= Array<Int>(2000000){0}
//큐의 끝을 가리키는 포인터
var endPtr:Int = -1
//큐의 시작을 가리키는 포인터
var startPtr:Int = 0

fun push(x:Int){
    endPtr++
    queue[endPtr]=x
}

fun pop():Int{
    if(startPtr>endPtr)
        return -1
    return queue[startPtr++]
}

fun size(): Int{
    return endPtr-startPtr+1
}

fun empty(): Int{
    if(startPtr>endPtr)
        return 1
    return 0
}

fun front():Int {
    if(startPtr>endPtr)
        return -1
    return queue[startPtr]
}

fun back(): Int{
    if(startPtr>endPtr)
        return -1
    return queue[endPtr]
}

fun main() {



    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    repeat(br.readLine().toInt()){
        val token = StringTokenizer(br.readLine())
        when(token.nextToken()){
            "push" -> push(token.nextToken().toInt())
            "pop" -> sb.append(pop()).append('\n')
            "size" -> sb.append(size()).append('\n')
            "empty" -> sb.append(empty()).append('\n')
            "front" -> sb.append(front()).append('\n')
            "back" -> sb.append(back()).append('\n')

        }

    }
    println(sb)

}
