import java.io.*;

public class Main {
    static int n;
    static int max=0;
    static int[] numList;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        numList = new int[n];
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num>max){
                max = num;
            }
            numList[i] = num;
        }
        dp = new Integer[max+1];
        setDp();
        for(int i=0; i<n; i++){
            int result = dp[numList[i]];
            bw.write(result+"\n");
        }
        bw.flush();
    }

    static void setDp(){
        for(int i=0; i<dp.length; i++){
            if(i==0){
                dp[i] = 1;
            }else if(i==1){
                dp[i] = dp[i-1];
            }else if(i==2){
                dp[i] = dp[i-2]+dp[i-1];
            }else{
                dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
            }
        }
    }
}
