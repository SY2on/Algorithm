import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k, n;
    static int[] cables;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        cables = new int[k];

        for(int i = 0; i < k; i++) {
            cables[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cables);

        System.out.println(binarySearch());

    }
    static long binarySearch(){
        long max = cables[cables.length-1];
        long min = 1;
        while(max>=min){
            long mid = (max+min)/2;
            long sum = 0;
            for(int cable : cables){
                sum+=cable/mid;
            }
            if(sum<n){ // 더 작게 잘라야함
                max = mid-1;
            }else {
                min = mid+1;
            }
        }
        return max;
    }
}
