import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mul5 = n/5;
        int mul25 = n/25;
        int mul125 = n/125;
        System.out.println(mul5+mul25+mul125);
    }
}
