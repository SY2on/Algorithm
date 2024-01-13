import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final boolean WHITE = true;
    static final boolean BLACK = false;
    static int n, m;
    static boolean[][] boards;

    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boards = new boolean[n+1][m+1];
        for(int i=1; i<=n; i++) {
            String input = br.readLine();
            for(int j=1; j<=m; j++) {
                if(input.charAt(j-1)=='W') boards[i][j] = WHITE;
                else boards[i][j] = BLACK;
            }
        }
        for(int i=1; i <= m-7; i++){
            for(int j=1; j<= n-7; j++){
                answer = Math.min(answer, divideAndConqWithStartBlack(i, j, 8));
                answer = Math.min(answer, divideAndConqWithStartWhite(i, j, 8));
            }
        }
        System.out.println(answer);
    }

    static int divideAndConqWithStartBlack(int x, int y, int size) {
        if(size == 2){
            int paint=0;
            if(boards[y][x] != BLACK) paint++;
            if(boards[y][x+1] != WHITE) paint++;
            if(boards[y+1][x] != WHITE) paint++;
            if(boards[y+1][x+1] != BLACK) paint++;
            return paint;
        }
        int half = size/2;
        return divideAndConqWithStartBlack(x, y, half) + divideAndConqWithStartBlack(x+half, y+half, half)+
                divideAndConqWithStartBlack(x, y+half, half) + divideAndConqWithStartBlack(x+half, y, half);

    }

    static int divideAndConqWithStartWhite(int x, int y, int size){
        if(size == 2){
            int paint=0;
            if(boards[y][x+1] != BLACK) paint++;
            if(boards[y+1][x] != BLACK) paint++;
            if(boards[y+1][x+1] != WHITE) paint++;
            if(boards[y][x] != WHITE) paint++;
            return paint;
        }
        int half = size/2;
        return divideAndConqWithStartWhite(x, y, half) + divideAndConqWithStartWhite(x+half, y+half, half)+
                divideAndConqWithStartWhite(x, y+half, half) + divideAndConqWithStartWhite(x+half, y, half);
    }
}
