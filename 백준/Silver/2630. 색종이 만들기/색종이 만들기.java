import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[][] paper;
    static int white =0 ;
    static int blue =0 ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }
        partition(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }


    public static void partition(int row, int col, int size) {

        if(sameColor(row, col, size)) {
            if(paper[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
    }

    //구역의 색깔이 같은지
    public static boolean sameColor(int row, int col, int size) {
        int color = paper[row][col];
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

}
