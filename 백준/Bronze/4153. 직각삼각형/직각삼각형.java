import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while(true){
            input = br.readLine();
            if(input.equals("0 0 0")) break;
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(isRightTriangle(a, b, c)) bw.write("right\n");
            else bw.write("wrong\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isRightTriangle(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);

        return Math.pow(arr[0], 2)+ Math.pow(arr[1], 2) == Math.pow(arr[2], 2);
    }
}
