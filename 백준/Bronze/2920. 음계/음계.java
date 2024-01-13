import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int ASC = 1;
    static final int DESC = -1;
    static final int MIX = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numLine = new int[8];
        for(int i=0; i<8; i++) {
            numLine[i] = Integer.parseInt(st.nextToken());
        }

        int flag = ASC;
        for(int i=0; i<8; i++) {
            if(numLine[i]!=i+1) {
                flag = DESC;
                break;
            }
        }
        if(flag == DESC) {
            for(int i=0; i<8; i++) {
                if(numLine[i]!=8-i) {
                    flag = MIX;
                    break;
                }
            }
        }
        if(flag == ASC) System.out.println("ascending");
        else if(flag == DESC) System.out.println("descending");
        else System.out.println("mixed");

    }
}
