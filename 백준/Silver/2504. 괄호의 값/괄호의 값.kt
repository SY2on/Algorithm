import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var stack = Stack<Char>()
    val list = br.readLine().toCharArray()
    var temp = 1
    var result = 0
    if((list[0]==')')||(list[0]==']')){
        result =0
    }else {
        for (i in list.indices) {
            if (list[i] == '(') {
                stack.push('(')
                temp *= 2
            } else if (list[i] == '[') {
                stack.push('[')
                temp *= 3
            } else if (list[i] == ')') {
                if(stack.empty()||stack.pop()!='('){
                    result = 0
                    break
                }
                val before = list[i - 1]
                if (before == '[') {
                    result = 0
                    break
                } else if (before == '(') {
                    result += temp
                    temp /= 2
                } else if ((before == ')') || before == ']') {
                    temp /= 2
                }
            } else if (list[i] == ']') {
                if(stack.empty()||stack.pop()!='['){
                    result = 0
                    break
                }
                val before = list[i - 1]
                if (before == '(') {
                    result = 0
                    break
                } else if (before == '[') {
                    result += temp
                    temp /= 3
                } else if ((before == ')') || before == ']') {
                    temp /= 3
                }
            }
        }
    }
    if(!stack.empty()){
        result=0
    }
    bw.write(result.toString())
    bw.close()
}