import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Jewel {
        int m;
        int v;
        Jewel(int m, int v){
            this.m = m;
            this.v = v;
        }

    }
    static int n;
    static int k;
    static List<Jewel> jewels = new ArrayList<>();
    static List<Integer> bags = new ArrayList<Integer>();
    static PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> o2.v- o1.v);
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            jewels.add(new Jewel(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        for(int i=0; i<k;i++){
            bags.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(bags); //가방 무게 오름차순
        Collections.sort(jewels, (o1, o2) -> o1.m-o2.m); //보석 무게 오름차순

        int idx =0;
        for(Integer bag : bags){
            while (idx < jewels.size()&&bag>=jewels.get(idx).m) {
                pq.offer(jewels.get(idx));
                idx++;
            }
            if(!pq.isEmpty()){
                result+=pq.poll().v;
            }
        }
        System.out.println(result);
    }

}
