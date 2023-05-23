import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    //진실을 아는 사람들 저장할 배열
    public static int[] truth;
    public static int[] parent;
    public static List<List> parties = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n; //사람 수
        int m; //파티 수
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        //이야기의 진실을 아는 사람
        String[] truthInput = br.readLine().split(" ");
        int truthNum = Integer.parseInt(truthInput[0]);
        if(truthNum==0){
            System.out.println(m);
            return;
        }else{
            truth = new int[truthNum];
        }
        for(int i=0; i<truthNum; i++){
            truth[i]=Integer.parseInt(truthInput[i+1]);
        }

        parent = new int[n+1];
        makeSet();

        for(int i=0; i<m; i++){
            String[] partyInfo = br.readLine().split(" ");
            int partyMemCount = Integer.parseInt(partyInfo[0]);
            List<Integer> party = new ArrayList<>();
            for(int j=0; j<partyMemCount; j++){
                party.add(Integer.parseInt(partyInfo[j+1]));
            }
            parties.add(party);
        }

        for(List<Integer> party : parties){
            for (int i=0; i<party.size(); i++) {
                if(i!=0){
                    union(party.get(i-1), party.get(i));
                }
            }
        }
        int result=0;
        for(List<Integer> party : parties){
            boolean canLie = true;
            int firstMem = party.get(0);
            for (int truthPerson: truth) {
                if(find(firstMem)==find(truthPerson)){
                    canLie = false;
                }
            }
            if(canLie){
                result++;
            }
        }
        System.out.println(result);


    }

    public static void makeSet(){
        for(int i=0; i<parent.length; i++){
            parent[i]=i;
        }
    }
    public static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!=rootY){
            parent[rootY] =rootX;
        }
    }

    public static int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            return find(parent[x]);
        }
    }
}
