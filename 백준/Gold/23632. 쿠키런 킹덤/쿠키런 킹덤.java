import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>(); //건물 j를 짓기 위해 자원 i가 필요함 i->j
    static List<List<Integer>> resources = new ArrayList<>(); //건물이 생산하는 자원 목록
    static int[] indegree; //건물 i를 짓기위한 재료중 충족되지 못한 재료 개수
    static boolean[] check; //리소스 체크 여부
    static List<Integer> result = new ArrayList<>();//지어진 건물
    static Queue<Integer> q1 = new LinkedList<Integer>();
    static Queue<Integer> q2 = new LinkedList<Integer>();
    static int n;
    static int m;
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        t = Integer.parseInt(input[2]);

        indegree = new int[n+1];
        check = new boolean[n+1];
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            resources.add(new ArrayList<>());
        }

        input = br.readLine().split(" ");
        for(int i=0; i<m; i++) {
            int factory = Integer.parseInt(input[i]);
            q1.add(factory);
        }
        for(int i=1; i<=n; i++) { //resources 채우기
            input = br.readLine().split(" ");
            for(int j=0; j<Integer.parseInt(input[0]); j++){
                resources.get(i).add(Integer.parseInt(input[j+1]));
            }
        }

        for(int i=0; i<n-m; i++) { //graph채우기
            input = br.readLine().split(" ");
            int factory = Integer.parseInt(input[0]);
            for(int j=0; j<Integer.parseInt(input[1]); j++){
                int resource = Integer.parseInt(input[j+2]);
                graph.get(resource).add(factory);
                indegree[factory]++;
            }
        }
        while(t>-1){
            topologicalSort();
            t--;
            while(!q2.isEmpty()){
                q1.offer(q2.poll());
            }
        }
        Collections.sort(result);
        bw.write(result.size()+"\n");
        for(Integer i : result){
            bw.write(i+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void topologicalSort() {
        while (!q1.isEmpty()){
            int factory = q1.poll();
            result.add(factory);
            for(Integer resource : resources.get(factory)){
                if(check[resource]){
                    continue;
                }
                for(Integer factory2 : graph.get(resource)){
                    if(--indegree[factory2]==0){
                        q2.offer(factory2);
                    }
                }
                check[resource]=true;
            }
        }
    }


}
