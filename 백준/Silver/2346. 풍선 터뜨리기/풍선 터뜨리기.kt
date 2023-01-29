import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val size = br.readLine().toInt()
    val token = StringTokenizer(br.readLine())
    var result = ArrayList<Int>()
    var balloonList = LinkedList<Int>()
    var balloonNumList = LinkedList<Int>()
    var index = 0
    var distance = 0
    for(i in 1 .. size){
        balloonList.add(token.nextToken().toInt())
        balloonNumList.add(i)
    }
    repeat(size-1){
        distance = balloonList.removeAt(index)
        result.add(balloonNumList.removeAt(index))

        if(distance>0){
            distance = distance%balloonList.size
            if(distance==0){
                distance = balloonList.size
            }
            if(index+distance>balloonList.size){
                index = index+distance-balloonList.size-1
            }else{
                index = index+distance-1
            }
        }else{
            distance = distance%balloonList.size
            if(distance==0){
                distance = balloonList.size*(-1)
            }
            if(abs(distance)>index){
                index += balloonList.size + distance
            }else{
                index +=distance
            }
        }
    }
    result.add(balloonNumList.removeAt(0))
    for(i in 0 until result.size){
        bw.write(result[i].toString())
        bw.write(" ")
    }
    bw.close()
}