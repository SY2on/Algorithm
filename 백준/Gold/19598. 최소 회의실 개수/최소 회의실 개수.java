import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static class meeting implements Comparable<meeting>{
        int startTime;
        int endTime;
        public meeting(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(meeting o) {
            if(this.startTime > o.startTime){
                return 1;
            }
            return -1;
        }
    }
    static ArrayList<meeting> meetingList = new ArrayList<>();
    static int n;
    static int[] rooms;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rooms = new int[n];
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            meetingList.add(new meeting(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        Collections.sort(meetingList);
        boolean find = false;
        for(int i=0; i<meetingList.size(); i++){
            find = false;
            for(int j=0; j<count; j++){
                if(rooms[j]<=meetingList.get(i).startTime){
                    rooms[j] = meetingList.get(i).endTime;
                    find = true;
                    break;
                }
            }
            if(!find){
                count++;
                rooms[count-1] = meetingList.get(i).endTime;
            }
        }
        System.out.println(count);
    }
}
