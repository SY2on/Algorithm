
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] available;
    static int bCnt=0;
    static int wCnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        available = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j <n; j++) {
                available[i][j] = Integer.parseInt(input[j]);
            }
        }
        blackSearch(new boolean[n][n], 0,1,0);
        whiteSearch(new boolean[n][n],0,0,0);

        System.out.println(bCnt+wCnt);
    }

    public static void blackSearch(boolean[][] visited, int row, int col, int cnt){
        bCnt = Math.max(bCnt, cnt);
        if(col>=n){
            row++;
            col = (row%2==0)?1:0;
        }
        if(row>=n){
            return;
        }

        if(isAvailable(visited,row,col)){
            visited[row][col] = true;
            blackSearch(visited,row,col+2,cnt+1);
        }

        visited[row][col]=false;
        blackSearch(visited,row,col+2,cnt);
    }

    public static void whiteSearch(boolean[][] visited, int row, int col, int cnt){
        wCnt = Math.max(wCnt, cnt);
        if(col>=n){
            row++;
            col = (row%2==0)?0:1;
        }
        if(row>=n){
            return;
        }

        if(isAvailable(visited,row,col)){
            visited[row][col] = true;
            whiteSearch(visited,row,col+2,cnt+1);
        }

        visited[row][col]=false;
        whiteSearch(visited,row,col+2,cnt);
    }

    public static boolean isAvailable(boolean[][] visited, int row, int col){
        if(available[row][col]==0)
            return false;

        for(int i =1; i<n; i++){
            if(row+i>=n||col+i>=n){
                break;
            }
            if(visited[row+i][col+i])
                return false;
        }
        for(int i =1; i<n; i++){
            if(row+i>=n||col-i<0){
                break;
            }
            if(visited[row+i][col-i])
                return false;
        }
        for(int i =1; i<n; i++){
            if(row-i<0||col-i<0){
                break;
            }
            if(visited[row-i][col-i])
                return false;
        }
        for(int i =1; i<n; i++){
            if(row-i<0||col+i>=n){
                break;
            }
            if(visited[row-i][col+i])
                return false;
        }
        return true;
    }
}
