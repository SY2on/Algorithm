import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static class Man implements Comparable<Man> {
        int paper;
        int interview;

        Man(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }

        @Override
        public int compareTo(Man o) {
            if (this.paper > o.paper) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Man> manList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String[] score = br.readLine().split(" ");
                Man man = new Man(Integer.parseInt(score[0]), Integer.parseInt(score[1]));
                manList.add(man);
            }
            System.out.println(greedy(n, manList));
        }
    }

    public static int greedy(int n, List<Man> manList) {
        Collections.sort(manList); //서류 석차 오름차순으로 정렬
        int interviewLine = manList.get(0).interview;
        int pass = 0;
        for (int j = 0; j < n; j++) {
            if (manList.get(j).interview <= interviewLine) {
                pass++;
                interviewLine = manList.get(j).interview;
            }
        }
        return pass;
    }
}
