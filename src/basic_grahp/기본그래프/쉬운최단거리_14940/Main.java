package basic_grahp.기본그래프.쉬운최단거리_14940;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] writeMap;
    static boolean[][] visited;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int startR = 0;
        int startC = 0;
        map = new int[n][m];
        writeMap = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startR = i;
                    startC = j;
                }
            }
        }
        writeMap[startR][startC] = 0;
        bfs(startR, startC);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] != 0)
                    writeMap[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(writeMap[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = poll[0] + dr[i];
                int nc = poll[1] + dc[i];

                if (nc < 0 || nc >= m || nr < 0 || nr >= n) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == 0) continue;
                q.offer(new int[]{nr, nc});
                writeMap[nr][nc] = writeMap[poll[0]][poll[1]] + 1;
                visited[nr][nc] = true;
            }
        }
    }
}
