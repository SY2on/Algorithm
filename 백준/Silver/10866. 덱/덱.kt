import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayDeque


fun main(){
    var dq = ArrayDeque<Int>()
    fun push_front(x:Int){
        dq.addFirst(x)
    }
    fun push_back(x:Int){
        dq.addLast(x)
    }
    fun pop_front():Int{
        if(dq.size==0)
            return -1
        return dq.removeFirst()
    }
    fun pop_back():Int{
        if(dq.size==0)
            return -1
        return dq.removeLast()
    }
    fun size():Int{
        return dq.size
    }
    fun empty():Int{
        if(dq.isEmpty())
            return 1
        return 0
    }

    fun front():Int{
        if(dq.size==0)
            return -1
        return dq.first()
    }

    fun back():Int{
        if(dq.size==0)
            return -1
        return dq.last()
    }

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(br.readLine().toInt()){
        val token = StringTokenizer(br.readLine())
        val order = token.nextToken()
        if(order=="push_front"){
            push_front(token.nextToken().toInt())
        }else if(order=="push_back"){
            push_back(token.nextToken().toInt())
        }else {
            when (order) {
                "pop_front" -> bw.write(pop_front().toString())
                "pop_back" -> bw.write(pop_back().toString())
                "size" -> bw.write(size().toString())
                "empty" -> bw.write(empty().toString())
                "front" -> bw.write(front().toString())
                "back" -> bw.write(back().toString())
            }
            bw.write("\n")
            bw.flush()
        }
    }
    bw.close()
}
