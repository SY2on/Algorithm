
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int n; //가수의 수
    static int m; //보조 pd 수
    static int[] indegree;
    static List<List<Integer>> array = new ArrayList<List<Integer>>();
    static Queue<Integer> q = new LinkedList<Integer>();
    static Queue<Integer> result = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        indegree = new int[n+1];
        for(int i=0; i<=n; i++){
            array.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            input = br.readLine().split(" ");
            for(int j=1; j<Integer.parseInt(input[0]); j++){
                int v1 = Integer.parseInt(input[j]);
                int v2 = Integer.parseInt(input[j+1]);
                array.get(v1).add(v2);
                indegree[v2]++;
            }
        }

        for(int i=1; i<=n; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        topologicalSort();
        if(result.size()<n){
            System.out.println(0);
            return;
        }
        while(!result.isEmpty()){
            bw.write(result.poll()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void topologicalSort(){
        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);
            for(Integer item : array.get(node)){
                if(--indegree[item]==0){
                    q.add(item);
                }
            }
        }
    }
}
