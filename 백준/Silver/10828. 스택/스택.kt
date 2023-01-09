import java.io.*
import java.util.*


//크기가 10000인 stack 생성
var stack = Array<Int>(10000){0};

//처음 스택의 높이는 -1
var top: Int = -1;

fun push(x: Int){
    top++
    stack[top]=x;
}
//스택에서 가장 위에 있는 정수를 빼고, 그 수를 return, 스택이 비어있으면 return -1
fun pop(): Int{
    if(top==-1)
        return -1
    val num = stack[top]
    top--
    return num
}

//스택 크기 출력
fun size(): Int{
    return top+1;
}

//스택이 비었으면 return 1, 아니면 0
fun empty(): Int{
    if(top==-1)
        return 1;
    else
        return 0;
}

//return 스택 가장 위 정수, 스택이 비어있으면 -1
fun top(): Int{
    if(top==-1)
        return -1;
    else
        return stack[top];
   }


fun main(args: Array<String>) {


    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    //입력받은 명령의 수만큼 반복
    repeat(br.readLine().toInt()){
        /*
        * String 두개 입력 받음
        * StringTokenizer는 공백을 기준으로 String을 split
        * */
        val token = StringTokenizer(br.readLine())
        val order = token.nextToken()
        if(order=="push")
            push(token.nextToken().toInt())
        else {
            when (order) {
                "pop" -> bw.write(pop().toString())
                "size" -> bw.write(size().toString())
                "empty" -> bw.write(empty().toString())
                "top" -> bw.write(top().toString())
            }
            bw.write("\n")
            bw.flush()
        }

    }
    bw.close()
}