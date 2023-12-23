package basic_technique.정렬.회의실_1931;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Meet[] meetList = new Meet[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetList[i] = new Meet(start, end);
        }

        Arrays.sort(meetList);
        int cnt = 0, end = 0;
        for ( int i = 0; i<n; i++){
            if(end <= meetList[i].start){
                cnt++;
                end = meetList[i].end;
            }
        }
        System.out.println(cnt);
    }

    public static class Meet implements Comparable<Meet> {
        int start;
        int end;

        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meet o) {
            if(end == o.end)
                return start - o.start;
            return end - o.end;
        }
    }
}
