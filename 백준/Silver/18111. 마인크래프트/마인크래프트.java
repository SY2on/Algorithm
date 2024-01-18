import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, b;
    static int sum, time = 0;
    static int minTime = Integer.MAX_VALUE;

    static List<Integer> heights = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                heights.add(Integer.parseInt(st.nextToken()));
            }
        }
        sum = heights.stream().mapToInt(Integer::intValue).sum();
        heights.sort((a, b) -> b - a);

        int endHeight = solve();
        System.out.println(minTime + " " + endHeight);
    }

    static int solve() {
        int blank;
        int removeBlock;
        int height = heights.get(0);
        int idx = 0;
        for (int h = height; h >= heights.get(n * m - 1); h--) {
            blank = h * n * m - sum;
            if (b >= blank) {
                if (minTime > time + blank) {
                    minTime = time + blank;
                } else {
                    return h+1;
                }
            }
            while (idx<n*m-1) {
                if (heights.get(idx) >= h)
                    idx++;
                else break;
            }
            removeBlock = idx;
            b += removeBlock;
            time += 2 * removeBlock;
            sum -= removeBlock;
        }
        return heights.get(idx);

    }
}
