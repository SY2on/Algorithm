import java.io.*;

public class Main {
    static String origin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            origin = br.readLine();
            if(origin.equals("0")) break;
            String reverse  = new StringBuilder(origin).reverse().toString();
            if (origin.equals(reverse)) bw.write("yes\n");
            else bw.write("no\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

}
