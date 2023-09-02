import java.io.*;

public class Main {
    static int n;
    static int[] height;
    static int[] leftCnt;
    static int[] rightCnt;
    static int[] closestIdx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        height = new int[n+1];
        leftCnt = new int[n+1];
        rightCnt = new int[n+1];
        closestIdx = new int[n+1];
        String[] input = br.readLine().split(" ");
        for(int i = 1; i<=n; i++){
            height[i] = Integer.parseInt(input[i-1]);
        }
        leftDp();
        rightDp();
        for(int i=1; i<=n; i++){
            int cnt = leftCnt[i]+rightCnt[i];
            if(cnt==0){
                bw.write("0"+"\n");
            }else{
                bw.write(cnt+" "+closestIdx[i]+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
    static void leftDp() {
        for(int i=2; i<=n; i++){
            for(int j=i-1; j>0; j--){
                if(height[j]>height[i]){
                    closestIdx[i] = j;
                    leftCnt[i] = leftCnt[j]+1;
                    break;
                }
            }
        }
    }
    static void rightDp() {
        for(int i=n-1; i>0; i--){
            for(int j=i+1; j<=n; j++){
                if(height[j]>height[i]){
                    if(closestIdx[i]==0||(j-i)<(i-closestIdx[i])){
                        closestIdx[i] = j;
                    }
                    rightCnt[i] = rightCnt[j]+1;
                    break;
                }
            }
        }
    }
}
