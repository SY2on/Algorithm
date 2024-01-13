import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] cards, targets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key,0)+1);
        }
        m = Integer.parseInt(br.readLine());
        targets = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            targets[i] = Integer.parseInt(st.nextToken());
        }
        for(int target : targets) {
            sb.append(map.getOrDefault(target, 0)).append(" ");
        }
        System.out.println(sb.toString());

    }

}
