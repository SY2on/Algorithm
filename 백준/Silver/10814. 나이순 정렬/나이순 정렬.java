import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<Member>();

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            Member m = new Member();
            m.age = Integer.parseInt(input[0]);
            m.name = input[1];
            m.order = i;
            list.add(m);
        }

        Collections.sort(list, new Member());

        for(Member m : list){
            bw.write(m.age + " " + m.name + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    public static class Member implements Comparator {
        public int age;
        public String name;
        public int order;

        Member(){}

        @Override
        public int compare(Object o1, Object o2) {
            Member m1 = (Member) o1;
            Member m2 = (Member) o2;
            if (m1.age == m2.age) {
                return m1.order - m2.order;
            } else return m1.age - m2.age;
        }
    }
}
