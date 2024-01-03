package basic_grahp.기본그래프.바이러스_2606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int E;
    static int[][] graph;
    static int[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        E = sc.nextInt();
        graph = new int[N + 1][N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < E; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }
        BFS(1);
        System.out.println(cnt - 1);
    }


    static void BFS(int node) {
        q.offer(node);
        visited[node] = 1;
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            cnt++;
            for (int i = 1; i <= N; i++) {
                if (visited[i] != 1 && graph[poll][i] == 1) {
                    q.offer(i);
                    visited[i] = 1;
                }
            }
        }
    }
}
