import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var list = br.readLine().toCharArray()
    var stickNum = 0
    var sum:Int=0
    for(i in list.indices){
        if (list[i]=='('){
            stickNum++
        }else{
            stickNum--
            if(list[i-1]=='('){
                sum+=stickNum
            }else{
                sum++
            }
        }
    }
    bw.write(sum.toString())
    bw.close()
}