import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];

        for(int i=0; i<n; i++) {
            words[i] = br.readLine();
        }

        List<String> answer = Arrays.stream(words).distinct().sorted((o1, o2) -> {
            if(o1.length() > o2.length()) return 1;
            else if(o1.length() < o2.length()) return -1;
            else return o1.compareTo(o2);
        }).collect(Collectors.toList());

        for(String s : answer){
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
