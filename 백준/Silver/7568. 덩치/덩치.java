import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] man = new int[n][3]; // 몸무게, 키, 등수
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            man[i][0] = Integer.parseInt(st.nextToken());
            man[i][1] = Integer.parseInt(st.nextToken());
            man[i][2] = 1;
        }

        //본인보다 뒤에있는 사람만 체크
        for (int i = 0; i<n; i++){
            for(int j=0; j<n; j++){
                if(man[j][0]>man[i][0]&&man[j][1]>man[i][1]) man[i][2]++;
            }
        }

        for(int[] m : man){
            bw.write(m[2]+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
