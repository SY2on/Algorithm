import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    static List<List<Integer>> array = new ArrayList<List<Integer>>();
    static Queue<Integer> result = new LinkedList<>();
    static int[] indegree;
    static int n;
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        t = Integer.parseInt(input[1]);
        indegree = new int[n+1];
        for(int i=0; i<=n; i++){
            array.add(new ArrayList<>());
        }
        for(int i=0; i<t; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<input.length-1; j++){
                int v1 = Integer.parseInt(input[j]);
                int v2 = Integer.parseInt(input[j+1]);
                array.get(v1).add(v2);
                indegree[v2]++;
            }
        }
        for(int i=1; i<=n; i++){
            if(indegree[i]==0){
                pq.add(i);
            }
        }
        topologicalSort();
        while(!result.isEmpty()){
            bw.write(result.poll()+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void topologicalSort(){
        while(!pq.isEmpty()){
            int node = pq.poll();
            result.add(node);
            for(Integer item : array.get(node)){
                if(--indegree[item]==0){
                    pq.add(item);
                }
            }
        }
    }
}
