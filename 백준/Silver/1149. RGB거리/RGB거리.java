import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n=0;

    static int[] rCost;
    static int[] bCost;
    static int[] gCost;

    static Integer[] rDp;
    static Integer[] bDp;
    static Integer[] gDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        rCost = new int[n];
        bCost = new int[n];
        gCost = new int[n];

        rDp = new Integer[n];
        bDp = new Integer[n];
        gDp = new Integer[n];

        for(int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            rCost[i] = Integer.parseInt(input[0]);
            bCost[i] = Integer.parseInt(input[1]);
            gCost[i] = Integer.parseInt(input[2]);
        }
        setDp();
        int result = Math.min(Math.min(rDp[n-1], bDp[n-1]), gDp[n-1]);
        System.out.println(result);
    }
    public static void setDp(){
        for(int i=0; i<n; i++){
            if(i==0){
                rDp[i] = rCost[i];
                bDp[i] = bCost[i];
                gDp[i] = gCost[i];
            }
            if(i>0){
                rDp[i] = Math.min(bDp[i-1]+rCost[i], gDp[i-1]+rCost[i]);
                bDp[i] = Math.min(rDp[i-1]+bCost[i], gDp[i-1]+bCost[i]);
                gDp[i] = Math.min(rDp[i-1]+gCost[i], bDp[i-1]+gCost[i]);
            }
        }
    }
}
