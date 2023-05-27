import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] stone;
    static List<List<Integer>> canGo;
    static Set<Integer> visited = new HashSet<Integer>();
    static Stack<Integer> nextVisit = new Stack<>();
    static boolean arrived = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        stone = new int[n];
        String[] stoneInput = br.readLine().split(" ");
        for (int i =0; i < n; i++){
            stone[i] = Integer.parseInt(stoneInput[i]);
        }

        visit(0);
        while(!nextVisit.isEmpty()){
            if(nextVisit.peek() == n-1){
                arrived = true;
                break;
            }
            visit(nextVisit.pop());
        }
        if(arrived){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    //i번째 돌 방문
    static void visit(int i){
        visited.add(i);
        findCanGo(i);
    }

    //이동 가능한 돌 찾기
    static void findCanGo(int i){
        for(int j=i+1; j< n; j++){
            if(j-i>k){
                break;
            }else if(visited.contains(j)){
                continue;
            }else{
                    if((j-i)*(Math.abs(stone[j]-stone[i])+1)<=k){
                        nextVisit.add(j);
                    }
            }
        }

    }

}

