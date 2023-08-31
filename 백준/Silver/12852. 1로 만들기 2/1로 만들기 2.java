import java.io.*;

public class Main {
    static int n;
    static Num[] dp;

    static class Num{
        int cnt;
        int before;

        Num(int cnt, int before) {
            this.cnt = cnt;
            this.before = before;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        dp = new Num[n+1];
        dp[1] = new Num(0, 1);

        for (int i = 2; i <= n; i++) {
            int cnt = Integer.MAX_VALUE;
            int before = 0;
            if (i % 3 == 0) {
                cnt = dp[i/3].cnt;
                before = i/3;
            }

            if (i % 2 == 0) {
                if (cnt>dp[i/2].cnt) {
                    cnt = dp[i/2].cnt;
                    before = i/2;
                }
            }

            if (cnt > dp[i-1].cnt) {
                cnt = dp[i-1].cnt;
                before = i-1;
            }

            dp[i] = new Num(cnt+1, before);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[n].cnt).append("\n");
        int tmp = n;
        while(tmp>1){
            sb.append(tmp).append(" ");
            tmp = dp[tmp].before;
        }
        sb.append(1);
        System.out.println(sb.toString());
    }
}
