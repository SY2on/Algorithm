import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int answer = 0;
    static int sum = 0, max = 0;
    static int[] honey;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        honey = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            honey[i] = Integer.parseInt(st.nextToken());
            sum += honey[i];
            max = Math.max(max,honey[i]);
        }
        answer = case1();
        answer = Math.max(answer, case2());
        answer = Math.max(answer, case3());


        System.out.println(answer);
    }
    // 양 사이드에 꿀벌 배치
    static int case1(){
        return sum-honey[0]-honey[n-1]+max;
    }
    //왼쪽에 몰아서 꿀벌 배치
    static int case2(){
        int beforeMax = 0;
        int bSide = sum - honey[0];
        for(int i=1; i<n-1; i++){
            bSide -= honey[i];
            int k = honey[i];
            beforeMax = Math.max(beforeMax, bSide-k);
        }
        return sum - honey[0] + beforeMax;
    }

    //오른쪽에 몰아서 꿀벌 배치
    static int case3(){
        int beforeMax = 0;
        int bSide = sum - honey[n-1];
        for(int i=n-2; i>0; i--){
            bSide -= honey[i];
            int k = honey[i];
            beforeMax = Math.max(beforeMax, bSide-k);
        }
        return sum - honey[n-1] + beforeMax;
    }
}
