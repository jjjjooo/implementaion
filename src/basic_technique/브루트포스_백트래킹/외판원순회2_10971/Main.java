package basic_technique.브루트포스_백트래킹.외판원순회2_10971;

import java.util.Scanner;

public class Main {
    static int n;
    static int[][] graph;

    static boolean[] visited;

    static int minLen = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visited = new boolean[n];
        graph = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                graph[i][j] = sc.nextInt();
        }
        recFunc(0,0 , 0 , 0);
        System.out.println(minLen);
    }

    static void recFunc(int start, int node, int sum, int cnt){
        if(cnt == n && start == node){
            minLen = Math.min(minLen, sum);
            return;
        }
        for(int i = 0; i< n; i++){
            if(!visited[i] && graph[node][i] != 0){
                visited[i] = true;
                recFunc(start, i, sum + graph[node][i], cnt + 1);
                visited[i] = false;
            }
        }
    }
}

