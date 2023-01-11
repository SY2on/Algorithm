import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.text.StringBuilder

val sb = StringBuilder()

class LinkedList{

    var head:Node? = null

    class Node(var data:Int){
        //다음 Node를 가리킴
        var next:Node? =null;
    }

    //리스트에 처음 값을 넣을 때
    fun addFirst(item: Int){
        head = Node(item)
    }
    fun add(item: Int) {
        if(head==null){
            addFirst(item)
        }else {
            var node = head
            while (node?.next != null)
                node = node?.next
            node?.next = Node(item)

        }
    }
    //인덱스는 1번부터
    fun delete(index: Int):Int? {
        var deletedNum: Int? = 0;
        if(index==1){
            deletedNum = head?.data
            head = head?.next
        }else{
            var preNode = head
            repeat(index-2){
                preNode = preNode?.next
            }
            deletedNum = preNode?.next?.data
            preNode?.next = preNode?.next?.next
        }
        return deletedNum
    }

}


fun permut(N: Int, K: Int):String{
    var list = LinkedList()
    for(i in 1..N) {
        list.add(i)
    }
    sb.append('<')
    var index = K
    var listSize = N
    repeat(N-1){
        sb.append(list.delete(index)).append(", ")
        listSize--
        index=(index-1+K)%listSize
        if(index==0)
            index=listSize
    }
    sb.append(list.delete(1)).append('>')
    return sb.toString()
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    bw.write(permut(token.nextToken().toInt(), token.nextToken().toInt()))
    bw.flush()
    bw.close()
}