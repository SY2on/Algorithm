import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList


fun main(){
    var stack = Stack<Int>()

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val size = br.readLine().toInt()
    var max=0
    var num=0
    var success = true
    var result = ArrayList<String>()
    for(i in 1..size){
        num=br.readLine().toInt()
        if(stack.empty()){
            for(j in max+1 .. num){
                stack.push(j)
                result.add("+")
            }
            max=num
            stack.pop()
            result.add("-")
        }else if(num<stack.peek()){
            success=false
            break;
        }else if(num==stack.peek()){
            stack.pop()
            result.add("-")
        }else{
            for(j in max+1 .. num){
                stack.push(j)
                result.add("+")
            }
            max=num
            stack.pop()
            result.add("-")
        }
    }
    if(!success){
        bw.write("NO")
        bw.close()
    } else{
        for(i in 0 until result.size){
            println(result.get(i))
        }
    }
}
