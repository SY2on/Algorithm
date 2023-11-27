import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] likes,board;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        likes = new int[n*n+1][4];
        board = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n*n; i++){
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            q.add(student);
            for (int j = 0; j < 4; j++) {
                likes[student][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(!q.isEmpty()) {
            int student = q.poll();
            putStudent(student);
        }
        int result=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int student = board[i][j];
                int cnt=0;
                for (int k = 0; k < 4; k++) {
                    int cx = i + dx[k];
                    int cy = j + dy[k];
                    if (cx < 0 || cx >= n || cy < 0 || cy >= n) {
                        continue;
                    }
                    for (int like : likes[student]) {
                        if (board[cx][cy] == like) {
                            cnt++;
                            break;
                        }
                    }
                }
                if(cnt>0){
                    result+=Math.pow(10,cnt-1);
                }
            }
        }
        System.out.println(result);
    }

    static void putStudent(int student){
        int[] seat = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) continue; //이미 배치된 좌석은 skip.
                int[] tmpSeat = {0, 0, i, j}; //좋아하는 학생 수 , 빈 칸 수, 행, 열
                for (int k = 0; k < 4; k++) {
                    int cx = i + dx[k];
                    int cy = j + dy[k];
                    if (cx < 0 || cx >= n || cy < 0 || cy >= n) {
                        continue;
                    }
                    if (board[cx][cy] == 0) tmpSeat[1]++; //빈칸 수++
                    else {
                        for (int like : likes[student]) {
                            if (board[cx][cy] == like) {
                                tmpSeat[0]++; //좋아하는 학생 수 ++
                                break;
                            }
                        }
                    }
                }
                if (seat == null) seat = tmpSeat;
                else if (select(tmpSeat, seat) > 0) seat = tmpSeat;
            }
        }
        board[seat[2]][seat[3]] = student;
    }

    static int select(int[] o1, int[] o2) {
        if(o1[0]!=o2[0]) return o1[0]-o2[0];
        else if(o1[1]!=o2[1]) return o1[1]-o2[1];
        else return 0;
    }
}
