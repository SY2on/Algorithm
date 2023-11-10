import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static List<Point> pointList;
    static List<List<Integer>> graph;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        for(int i = 0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            pointList = new ArrayList<>();
            for(int j=0; j<n+2; j++) {
                st = new StringTokenizer(br.readLine());
                pointList.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            graph = new ArrayList<>();
            for(int j=0; j<n+2; j++){
                graph.add(new ArrayList<>());
            }
            for(int j=0; j<n+2; j++){
                for(int k=0; k<n+2; k++){
                    if(k==j) continue;
                    if(Math.abs(pointList.get(j).x-pointList.get(k).x)+Math.abs(pointList.get(j).y-pointList.get(k).y)<=1000){
                        graph.get(j).add(k);
                    }
                }
            }
            visited = new boolean[n+2];
            if(bfs(0, n+1)){
                bw.write("happy\n");
            }else{
                bw.write("sad\n");
            }
             q.clear();
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static boolean bfs(int start, int end){
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int parent = q.poll();
            visited[parent] = true;
            if(parent==end) return true;
            for(int child : graph.get(parent)){
                if(visited[child]) continue;
                q.add(child);
            }
        }
        return false;
    }

}
class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
