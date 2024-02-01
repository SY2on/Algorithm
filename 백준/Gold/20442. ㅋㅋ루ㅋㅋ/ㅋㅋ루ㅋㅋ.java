import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        int l, r;
        int base = 0; //양 사이드 K 짝궁 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        l = 0;
        r = line.length - 1;

        int rCnt = 0;
        for (char c : line) {
            if (c == 'R') rCnt++;
        }
        if (rCnt == 0) {
            System.out.println(0);
            return;
        }

        while(l<=r){
            if(line[l]=='K'&&line[r]=='K') {
                base++;
                l++;
                r--;
            }else if(line[l]=='R') {
                answer = Math.max(answer, 2*base + rCnt);
                l++;
                rCnt--;
            }else if(line[r]=='R'){
                answer = Math.max(answer, 2*base + rCnt);
                r--;
                rCnt--;
            }
        }
        System.out.println(answer);
    }
}