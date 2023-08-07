import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static char[][] star;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        star = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                star[i][j] = ' ';
            }
        }
        divide(n,0,0);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void divide(int size, int row, int col){
        if(size == 3){
            conquer(row, col);
        }else{
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(i==1 && j==1)
                        continue;
                    int dividedSize = size/3;
                    divide(dividedSize, row+i*dividedSize, col+j*dividedSize);
                }
            }
        }
    }
    public static void conquer(int row, int col){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                star[row+i][col+j] = '*';
            }
        }
        star[row+1][col+1] = ' ';
    }
}