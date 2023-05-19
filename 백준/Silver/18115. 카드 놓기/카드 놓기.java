import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        List<Integer> order = new LinkedList<Integer>();
        for(int i = 1; i<=n; i++){
            int skill = Integer.parseInt(input[n-i]);
            if(skill == 1){
                order.add(0,i);
            }else if(skill == 2){
                order.add(1, i);
            }else if(skill == 3){
                order.add(i);
            }
        }

        for(Integer card:order){
            bw.write(card+" ");
        }
        bw.flush();
        bw.close();
    }
}
