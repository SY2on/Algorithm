import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int c;
    static int[] pos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]  input  = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        pos = new int[n];
        for(int i=0; i<n; i++){
            pos[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(pos);
        //
        //System.out.println("pos: "+Arrays.toString(pos));
        //
        int maxD = binarySearch(0,pos[n-1]);
        System.out.println(maxD);
    }
    public static int binarySearch(int s, int e){
        if(s<e){
            int mid = (s+e)/2;
            if(check(mid+1)){
                return binarySearch(mid+1,e);
            }else{
                return binarySearch(s,mid);
            }
        }else {
            return s;
        }
    }

    public static boolean check(int d){
        //System.out.println("=======================");
        //System.out.println("checking start...");
        int count = 1;
        int now = 0;
        //System.out.println("d = " + d);
        //System.out.println("count = " + count);
        //System.out.println("now = " + now);
        while (pos[n-1] - pos[now] >= d) {
            for (int i = now + 1; i < n; i++) {
                if ((pos[i] - pos[now]) >= d) {
                    count++;
                    now = i;
                    //System.out.println("now change = " + now);
                    //System.out.println("count change = " + count);
                    break;
                }
            }
        }
        //System.out.println("checking finish");
        //System.out.println("count = " + count);
        //System.out.println("=======================");
        return count >= c;
    }
}
