import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] paper;
    public static int n;
    public static int[] count = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] lines = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                paper[i][j] = Integer.parseInt(lines[j]);
            }
        }
        conquer(n,0,0);
        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }
    public static void divide(int size, int row, int col){
        int dividedSize = size/3;
        conquer(dividedSize, row, col);
        conquer(dividedSize, row, col+dividedSize);
        conquer(dividedSize, row, col+2*dividedSize);
        conquer(dividedSize, row+dividedSize, col);
        conquer(dividedSize, row+dividedSize, col+dividedSize);
        conquer(dividedSize, row+dividedSize, col+2*dividedSize);
        conquer(dividedSize, row+2*dividedSize, col);
        conquer(dividedSize, row+2*dividedSize, col+dividedSize);
        conquer(dividedSize, row+2*dividedSize, col+2*dividedSize);
    }
    public static void conquer(int size, int row, int col){
        if(size==1){
            if(paper[row][col]==-1){
                count[0]++;
            }else if(paper[row][col]==0){
                count[1]++;
            }else if(paper[row][col]==1){
                count[2]++;
            }
        }else{
            boolean check = true;
            int num = paper[row][col];
            for(int i = row; i < row+size; i++){
                if(check) {
                    for(int j = col; j < col+size; j++){
                        if (paper[i][j] != num) {
                            check = false;
                            break;
                        }
                    }
                }else{
                    break;
                }
            }
            if(check) {
                if(num==-1){
                    count[0]++;
                }else if(num==0){
                    count[1]++;
                }else if(num==1){
                    count[2]++;
                }
            }else{
                divide(size, row, col);
            }
        }

    }
}
