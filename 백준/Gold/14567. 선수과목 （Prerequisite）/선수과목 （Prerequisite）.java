import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    static Queue<Integer> result = new LinkedList<>();
    static List<List<Integer>> array = new ArrayList<>();
    static int[] indegree;
    static int n;
    static int m;
    static int time;
    static int[] semester;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        indegree = new int[n+1];
        semester = new int[n+1];
        for(int i=0; i<=n; i++){
            array.add(new ArrayList<Integer>());
        }
        for(int i=0; i<m; i++){
            input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            array.get(v1).add(v2);
            indegree[v2]++;
        }
        time = 0;
        while(result.size()<n){
            time++;
            topologicalSort();
        }
        for(int i=1; i<=n; i++){
            bw.write(semester[i]+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void topologicalSort(){
        for(int i=1; i<=n; i++){
            if(indegree[i]==0&&!result.contains(i)){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            semester[node] = time;
            result.offer(node);
            for(Integer item : array.get(node)){
                indegree[item]--;
            }
        }
    }
}
