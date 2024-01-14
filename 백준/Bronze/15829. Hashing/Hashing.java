import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static final int MOD = 1234567891;
    static final int R = 31;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = input[i] - 'a' + 1;
        }
        long sum = 0;
        for(int i=0; i<n; i++){
            sum+=num[i]*getSimplePow(i);
            sum%=MOD;
        }
        System.out.println(sum);
        br.close();
    }

    static long getSimplePow(int n){
        long pow = 1;
        for(int i=0; i<n; i++) {
            pow*=R;
            pow%=MOD;
        }
        return pow;
    }
}
