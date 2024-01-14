import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int sum=0, max=-4000, min = 4000;
    static Map<Integer, Integer> map = new HashMap<>();

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr= new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int n : arr){
            max = Math.max(n, max);
            min = Math.min(n, min);
            sum += n;
            map.put(n, map.getOrDefault(n,0)+1);
        }
        Arrays.sort(arr);

        int mode = arr[0];
        //제일 작은 최빈값
        for(int key : arr){
            if(map.get(key) > map.get(mode)) mode = key;
        }
        int find = mode;
        
        //두번째로 작은 최빈값
        for(int n : arr){
            if(map.get(n) == map.get(mode) && n != mode){
                find = n;
                break;
            }
        }
        bw.write(Math.round((double)sum/n) + "\n");
        bw.write(arr[n/2]+ "\n");
        bw.write(find + "\n");
        bw.write(max-min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
