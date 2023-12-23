package basic_technique.정렬.화살표그리기_15970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        input();
        func();
        System.out.printf(String.valueOf(func()));
    }

    static int N;
    static ArrayList<Integer>[] a;


    private static int func() {
        for (int color = 1; color <= N; color++) {
            Collections.sort(a[color]);
        }
        int ans = 0;
        for(int color = 1; color <=N; color++){
            for(int i=0; i<a[color].size(); i++){
                int left = toLeft(color, i);
                int right = toRight(color, i);
                ans += Math.min(left, right);
            }
        }
        return ans;
    }

    static int toLeft(int color, int idx){
        if(idx == 0) return Integer.MAX_VALUE;
        return a[color].get(idx) - a[color].get(idx-1);
    }

    static int toRight(int color, int idx){
        if(idx + 1 == a[color].size()) return Integer.MAX_VALUE;
        return a[color].get(idx+1) - a[color].get(idx);
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        a = new ArrayList[N + 1];
        for (int color = 1; color <= N; color++) {
            a[color] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= N; i++) {
            int loc, color;
            st = new StringTokenizer(br.readLine());
            loc = Integer.parseInt(st.nextToken());
            color = Integer.parseInt(st.nextToken());
            a[color].add(loc);
        }
    }
}