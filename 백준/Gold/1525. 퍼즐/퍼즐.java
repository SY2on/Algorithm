import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final String COMPLETE = "123456780";
    static boolean solved = false;
    static Map<String,Integer> visited = new HashMap<>();
    static Queue<String> q = new LinkedList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String input = br.readLine().replace(" ", "");
            sb.append(input);
        }
        String start = sb.toString();
        visited.put(start,0);
        q.add(start);
        dfs();
        if(solved){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }
    }

    static void dfs() {
        while(!q.isEmpty()){
            String input = q.poll();
            int count = visited.get(input);
            if (input.equals(COMPLETE)) {//정렬 완료하면
                result = Math.min(result, count);
                solved = true;
                continue;
            }
            int blank = input.indexOf("0");
            if ((blank + 1)%3!=0) {
                StringBuilder sb = new StringBuilder(input);
                char tmp = sb.charAt(blank + 1);
                sb.setCharAt(blank, tmp);
                sb.setCharAt(blank + 1, '0');
                String str = sb.toString();
                if (!visited.containsKey(str)) {
                    visited.put(str,count+1);
                    q.add(str);
                }
            }
            if (blank%3!=0) {
                StringBuilder sb = new StringBuilder(input);
                char tmp = sb.charAt(blank - 1);
                sb.setCharAt(blank, tmp);
                sb.setCharAt(blank - 1, '0');
                String str = sb.toString();
                if (!visited.containsKey(str)) {
                    visited.put(str,count+1);
                    q.add(str);
                }
            }
            if (blank + 3 <= 8) {
                StringBuilder sb = new StringBuilder(input);
                char tmp = sb.charAt(blank + 3);
                sb.setCharAt(blank, tmp);
                sb.setCharAt(blank + 3, '0');
                String str = sb.toString();
                if (!visited.containsKey(str)) {
                    visited.put(str,count+1);
                    q.add(str);
                }
            }
            if (blank - 3 >= 0) {
                StringBuilder sb = new StringBuilder(input);
                char tmp = sb.charAt(blank - 3);
                sb.setCharAt(blank, tmp);
                sb.setCharAt(blank - 3, '0');
                String str = sb.toString();
                if (!visited.containsKey(str)) {
                    visited.put(str,count+1);
                    q.add(str);
                }
            }

        }


    }
}
