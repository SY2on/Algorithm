import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<String> set = new HashSet<>();
    static Set<String> dupleSet = new HashSet<>();
    static int cnt = 0;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                dupleSet.add(name);
            }
        }
        sb.append(dupleSet.size()).append("\n");
        dupleSet.stream().sorted(String::compareTo).forEach(n -> sb.append(n).append("\n"));
        System.out.println(sb.toString());
    }
}
