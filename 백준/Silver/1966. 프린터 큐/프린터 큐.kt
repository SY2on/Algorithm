import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val testCase = br.readLine().toInt()
    fun checkOrder(priorityList:LinkedList<Int>,thatPoint:Int):Int{
        var queueMax = PriorityQueue<Int>(Collections.reverseOrder())
        queueMax.addAll(priorityList)
        var point = thatPoint
        var order = 1
        var queue:Queue<Int> = LinkedList()
        queue = priorityList
        while(true){
            if(point==0){
                if (queue.peek()==queueMax.peek()) {
                    return order
                }else{
                    queue.offer(queue.poll())
                    point=queue.size-1
                }
            }else{
                if(queue.peek()==queueMax.peek()){
                    queue.poll()
                    queueMax.poll()
                    order++
                }else{
                    queue.offer(queue.poll())
                }
                point--
            }
        }
    }
    repeat(testCase){
        var token = StringTokenizer(br.readLine())
        val docSize = token.nextToken().toInt()
        val thatPoint = token.nextToken().toInt()
        val token2 = StringTokenizer(br.readLine())
        var priorityList = LinkedList<Int>()
        repeat(docSize){
            priorityList.add(token2.nextToken().toInt())
        }
        bw.write(checkOrder(priorityList, thatPoint).toString())
        bw.write("\n")
    }
    bw.close()
}