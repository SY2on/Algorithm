import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;

        // 소수가 아닌 것들은 거르기
        for (int i = 2; i <= n; i++) {
            if(arr[i]){ //i 가 소수라면
                //i의 배수들은 소수가 아님
                for(int j=2; j*i<=n; j++){
                    arr[i*j]=false;
                }
            }
        }
        for(int i=m; i<=n; i++){
            if(arr[i]) bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
