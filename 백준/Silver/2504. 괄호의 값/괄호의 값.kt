import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

class Token(value:Int, pos:Int){
    var value = value
    var pos = pos
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val input = br.readLine()

    var tokens = Stack<Token>()

    tokens.push(Token(0,-1))

    for(i in input.indices){
        if(input[i]=='('||input[i]=='['){
            tokens.push(Token(0,i))
        }else{
            val openTag = if(input[i]==')'){'('} else {'['}

            //짝맞추기 실패
            if(tokens.peek().pos==-1||input[tokens.peek().pos]!=openTag){
                tokens.clear()
                break
            }
            val token = tokens.pop()
            val num = if(input[i]==')'){2}else{3}
            //(), []인 상황이라면
            if(token.pos+1==i){
                tokens.peek().value+=num
            }else{
                tokens.peek().value+= token.value*num
            }
        }
    }

    if(tokens.size!=1){
        bw.write("0")
    }else{
        bw.write(tokens.peek().value.toString())
    }
    bw.close()
}