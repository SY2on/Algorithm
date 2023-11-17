import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long cHp,atk;
    static int[][] rooms;
    static final int MONSTER = 1;
    static final int POTION = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        atk = Long.parseLong(st.nextToken());
        rooms = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            rooms[i][0] = Integer.parseInt(st.nextToken());
            rooms[i][1] = Integer.parseInt(st.nextToken());
            rooms[i][2] = Integer.parseInt(st.nextToken());
        }
        cHp = 0L;
        long min = cHp;
        for (int i = 0; i < n; i++) {
            if(rooms[i][0]==MONSTER){
                cHp-=(long)((rooms[i][2]-1)/atk)*rooms[i][1];
                min = Math.min(min, cHp);
            }else{
                atk+=rooms[i][1];
                cHp = Math.min(0, cHp+rooms[i][2]);
            }
        }
        System.out.println(Math.abs(min)+1);
    }
}
