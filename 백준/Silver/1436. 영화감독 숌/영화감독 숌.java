import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 666; i < Integer.MAX_VALUE; i++) {
            if(String.valueOf(i).contains("666")) n--;
            if(n==0) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
