import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x, y;
        StringTokenizer st = new StringTokenizer(br.readLine());
        ;

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int gap = y - x;
        int day = 0;

        while (gap > 0) {
            day++;
            if (day % 2 == 0) {
                gap -= day / 2;
            } else {
                gap -= (day/2 +1);
            }
        }

        System.out.println(day);
        br.close();

    }
}
