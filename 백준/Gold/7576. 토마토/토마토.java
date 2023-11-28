import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] box;
    static int day = 0;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static final int[] END_DAY = {-1,-1};
    static Queue<int[]> ripe = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        for (int i = 0; i < n; i++) { //토마토 정보 input
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) { //익은 토마토 queue에 저장+flag체크
            for (int j = 0; j < m; j++) {
                int tomato = box[i][j];
                if (tomato == 1) {//익은 토마토
                    ripe.offer(new int[] {i,j});

                }

            }
        }
        allRipeDay();
        boolean flag = true; //모두 익을 수 있는지
        for(int[] row : box){
            for(int cell : row){
                if(cell==0) {
                    flag = false;
                    break;
                }
            }
            if(flag==false) break;
        }
        if(flag==false) {
            System.out.println(-1);
        }else{
            System.out.println(day);
        }
    }

    static void allRipeDay(){
        ripe.offer(END_DAY);//day checking 용
        while(true) {
            int[] tomato = ripe.poll();
            if (Arrays.equals(tomato, END_DAY)) { //하루가 끝나면
                if (ripe.isEmpty()) return;
                else {
                    day++;
                    ripe.offer(END_DAY);
                }
            } else {
                int x = tomato[0];
                int y = tomato[1];
                for (int k = 0; k < 4; k++) {
                    int cx = x + dx[k];
                    int cy = y + dy[k];
                    if (cx < 0 || cx >= n || cy < 0 || cy >= m) {
                        continue;
                    }
                    if (box[cx][cy] == 0) { //주위에 안 익은 토마토가 있으면
                        box[cx][cy] = 1; //익힌다.
                        ripe.offer(new int[] {cx, cy});
                    }
                }
            }
        }
    }
}
