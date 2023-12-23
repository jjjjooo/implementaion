package basic_technique.정렬.국영수_10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        func();
    }

    static int N;
    static int[] P;

    static Elem[] B;

    private static void func() {
        Arrays.sort(B);
        for (int b_idx = 0; b_idx < N; b_idx++) {
            P[B[b_idx].idx] = b_idx;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = new Elem();
            B[i].num = Integer.parseInt(st.nextToken());
            B[i].idx = i;
        }
    }

    static class Elem implements Comparable<Elem> {
        public int num;
        public int idx;


        @Override
        public int compareTo(Elem other) {
            if (num != other.num) return num - other.num;
            return idx - other.idx;
        }
    }
}