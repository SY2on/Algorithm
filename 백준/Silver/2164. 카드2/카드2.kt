import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*



fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()

    var q:Queue<Int> = LinkedList()
    for(i in 1 .. N){
        q.add(i)
    }
    //카드가 한장만 남을 때 까지 반복
    while (q.size>1){
        //맨앞 카드 버림
        q.remove()

        //제일 위에 있는 카드를 제일 아래로 옮김
        var tmp = q.remove()
        q.add(tmp)
    }
    bw.write(q.peek().toString())
    bw.close()

}
