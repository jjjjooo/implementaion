package basic_grahp.기본그래프.연결요소의개수_11724;

import java.util.Scanner;

public class Main {
    static int n, m;
    static boolean[] visited;
    static int[][] graph;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        for(int i = 1; i<=n; i++){
            if(!visited[i]){
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int i = 1; i <= n; i++) {
            if(graph[node][i] == 1 && !visited[i])
                dfs(i);
        }
    }
}
