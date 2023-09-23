import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] N;
    static List<Integer> fi = new ArrayList<Integer>();
    static int M;
    static int Q;
    static List<Integer> seq = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input =br.readLine().split(" ");
        Q = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        N = new int[Q];
        fi.add(0);
        fi.add(1);
        seq.add(0);
        seq.add(1);
        int size = 2;
        while(true){
            int next = (fi.get(size-2)+fi.get(size-1))%M;
            fi.add(next);
            size++;
            if(next>=100){
                seq.add(next/100);
                seq.add(next%100/10);
                seq.add(next%10);
            }else if(next>=10){
                seq.add(next%100/10);
                seq.add(next%10);
            }else{
                seq.add(next%10);
            }
            if(fi.get(size-2) == 0 && fi.get(size-1) == 1)
                break;
        }
        int period = seq.size()-2;
        for(int i=0; i<Q; i++){
             N[i] = new BigInteger(br.readLine()).remainder(BigInteger.valueOf(period)).intValue();
        }
        for(int item : N){
            bw.write(seq.get(item)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
