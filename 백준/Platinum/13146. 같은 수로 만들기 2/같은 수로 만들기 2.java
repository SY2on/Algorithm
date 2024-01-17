import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int n;
    static int max = 0;
    static int before, now;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        before = Integer.parseInt(br.readLine());
        max = before;
        for (int i = 1; i < n; i++) {
            now = Integer.parseInt(br.readLine());
            if (before < now) {
                count += now - before;
            }
            max = Math.max(max, now);
            before = now;
        }
        count += max - now;

        System.out.println(count);

    }

}
