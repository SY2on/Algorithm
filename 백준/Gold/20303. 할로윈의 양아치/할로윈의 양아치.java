import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int k;
    static int[] candy;
    static int[] parent;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        candy = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }

        init_union();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        //집합의 root 목록
        List<Integer> roots = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            collectCandies(i);
            if (find(i) == i) roots.add(i);
        }

        int dp[] = new int[k];

        for (Integer root : roots) {
            if(-parent[root] >= k) continue;
            for (int j = k - 1; j + parent[root] >= 0; j--)
                dp[j] = Math.max(dp[j], dp[j + parent[root]] + candy[root]);
        }

        System.out.println(dp[k-1]);


    }

    static void init_union() {
        for (int i = 1; i < n+1; i++) {
            parent[i] = -1;
        }
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] += parent[rootY];
            parent[rootY] = rootX;
        }
    }

    // root node 를 찾는 함수
    static int find(int x) {
        //루트 노드를 만나면 반환
        if (parent[x] < 0) {
            return x;
        }
        //루트 노드가 아니면 부모노드를 따라가며 루트노드를 찾음
        parent[x] = find(parent[x]);
        return parent[x];
    }

    //root 한테 사탕 몰빵
    static void collectCandies(int x) {
        int root = find(x);
        if (root == x) return;
        candy[root] += candy[x];
    }

}