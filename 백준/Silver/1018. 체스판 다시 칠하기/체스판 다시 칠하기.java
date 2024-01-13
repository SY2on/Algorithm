import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] boards;

    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boards = new char[n+1][m+1];
        for(int i=1; i<=n; i++) {
            String input = br.readLine();
            for(int j=1; j<=m; j++) {
                boards[i][j] = input.charAt(j-1);
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
            if(boards[y][x] != 'B') paint++;
            if(boards[y][x+1] != 'W') paint++;
            if(boards[y+1][x] != 'W') paint++;
            if(boards[y+1][x+1] != 'B') paint++;
            return paint;
        }
        int half = size/2;
        return divideAndConqWithStartBlack(x, y, half) + divideAndConqWithStartBlack(x+half, y+half, half)+
                divideAndConqWithStartBlack(x, y+half, half) + divideAndConqWithStartBlack(x+half, y, half);

    }

    static int divideAndConqWithStartWhite(int x, int y, int size){
        if(size == 2){
            int paint=0;
            if(boards[y][x+1] != 'B') paint++;
            if(boards[y+1][x] != 'B') paint++;
            if(boards[y+1][x+1] != 'W') paint++;
            if(boards[y][x] != 'W') paint++;
            return paint;
        }
        int half = size/2;
        return divideAndConqWithStartWhite(x, y, half) + divideAndConqWithStartWhite(x+half, y+half, half)+
                divideAndConqWithStartWhite(x, y+half, half) + divideAndConqWithStartWhite(x+half, y, half);
    }
}
