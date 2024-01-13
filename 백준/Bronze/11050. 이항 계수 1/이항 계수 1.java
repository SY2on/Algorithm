import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        System.out.println(binoCoef());
    }

    //이항 계수 구하기
    public static int binoCoef() {
        int[][] dp = new int[n + 1][n + 1];
        for(int i=1; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for(int j=1; j <=k; j++) {
                dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
            }
        }
        return dp[n][k];
    }
}
