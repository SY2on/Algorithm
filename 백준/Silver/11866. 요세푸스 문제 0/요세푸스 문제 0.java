import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> dq = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++){
            dq.offerLast(i);
        }
        bw.write("<");
        while(dq.size()>1){
            for(int i = 0; i < k - 1; i++){
                dq.offerLast(dq.pollFirst());
            }
            bw.write(dq.pollFirst()+", ");
        }
        bw.write(dq.pollFirst()+">");
        bw.flush();
        bw.close();
        br.close();
    }
}
