import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[] seq;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        seq = new int[n];
        dp = new Integer[n];

        int maxLength = 0;

        String[] input = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            seq[i] = Integer.parseInt(input[i]);
        }
        for(int i=0; i<n; i++){
            maxLength = Math.max(setDp(i), maxLength);
        }

        System.out.println(maxLength);
    }
    static int setDp(int index){
        //방문 한적 없는 위치 라면
        if(dp[index] == null){
            dp[index] = 1;
        }

        for(int i=index; i>=0; i--){
            //seq[index]가 부분 수열의 끝인 경우
            if(seq[i] < seq[index]){
                dp[index] = Math.max(dp[index], dp[i]+1);
            }
        }

        return dp[index];
    }
}
