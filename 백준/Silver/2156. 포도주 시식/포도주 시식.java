import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int answer = 0;
    static int[] wine;
    static int[] yDp = new int[3];
    static int[] nDp = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        wine = new int[n];

        for(int i=0; i<n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        
        if(n<3){
            for(int i : wine){
                answer+=i;
            }
            System.out.println(answer);
            return;
        }

        //init
        yDp[0] = wine[0];
        yDp[1] = wine[0]+wine[1];
        nDp[1] = wine[0];

        for(int i=2; i<n; i++){
            if(i%3==0){
                nDp[0] = Math.max(nDp[2],yDp[2]);
                yDp[0] = Math.max(nDp[2],nDp[1]+wine[i-1])+wine[i];
            }else if(i%3==1){
                nDp[1] = Math.max(nDp[0],yDp[0]);
                yDp[1] = Math.max(nDp[0], nDp[2]+wine[i-1])+wine[i];
            }else if(i%3==2){
                nDp[2] = Math.max(nDp[1],yDp[1]);
                yDp[2] = Math.max(nDp[1], nDp[0]+wine[i-1])+wine[i];
            }
        }

        int answer=0;
        if((n-1)%3==0){
            answer = Math.max(nDp[0], yDp[0]);
        }else if((n-1)%3==1){
            answer = Math.max(nDp[1], yDp[1]);
        }else if((n-1)%3==2){
            answer = Math.max(nDp[2], yDp[2]);
        }

        System.out.println(answer);
    }
}
