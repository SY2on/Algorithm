import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        blackJack(list);
        System.out.println(answer);

    }

    public static void blackJack(List<Integer> list) {
        list.sort(null);
        int f, l, r;
        for (f = 0; f < list.size() - 2; f++) {
            l = f + 1;
            r = list.size() - 1;
            while (l < r) {
                int sum = list.get(f) + list.get(l) + list.get(r);
                if (sum == m) {
                    update(m);
                    return;
                } else if(sum < m){
                    update(sum);
                    l++;
                } else {
                    r--;
                }
            }
        }
    }
    public static void update(int num){
        if(m-answer > m-num) answer = num;
    }
}
