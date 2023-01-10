import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun checkVPS(targetString: String):Boolean{
    var checking:Int =0;
    for(i in targetString.indices){
        when(targetString[i]) {
            '(' -> checking++
            ')' -> checking--;
        }
        if(checking<0)
            return false
    }
    if(checking==0)
        return true
    return false
}

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(br.readLine().toInt()){
        if(checkVPS(br.readLine()))
            bw.write("YES")
        else
            bw.write("NO")
        bw.write("\n")
        bw.flush()
    }
    bw.close()
}