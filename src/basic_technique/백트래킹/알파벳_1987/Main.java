package basic_technique.백트래킹.알파벳_1987;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] map;
    static boolean[] alpha = new boolean[26];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new int[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++)
                map[i][j] = input.charAt(j) - 'A';
        }
        visited[0][0]  = 1 <<(map[0][0]);
        alpha[map[0][0]] = true;
        System.out.println(func(0,0));
    }

    static int func(int r, int c) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int nextRow = r + dr[i];
            int nextCol = c + dc[i];

            if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C) continue;
            int next = map[nextRow][nextCol];
            if(alpha[next]) continue;
            int route = 1 << next;
            if(visited[nextRow][nextCol] == (visited[r][c] | route)) continue;
            visited[nextRow][nextCol] = visited[r][c] | route;
            alpha[next] = true;
            int nextRes = func(nextRow, nextCol);
            result = Math.max(result, nextRes);
            alpha[next] = false;
        }
        return result + 1;
    }
}
