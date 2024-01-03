package basic_grahp.BFS.미로탐색_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m,n;
    static int[][] miro;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static Queue<int[]> q;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        miro = new int[n][m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++)
                miro[i][j] = s.charAt(j) - '0';
        }

        visited = new boolean[n][m];
        visited[0][0] = true;

        BFS(0,0);

        System.out.println(miro[n-1][m-1]);
    }

    public static void BFS(int row, int col) {
        q = new LinkedList<>();
        q.offer(new int[] {row,col});

        while(!q.isEmpty()){
            int[] loc = q.poll();
            int locX = loc[0];
            int locY = loc[1];

            for(int i = 0; i < 4; i++){
                int nextX = locX + dx[i];
                int nextY = locY + dy[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;

                if(visited[nextX][nextY] || miro[nextX][nextY] == 0) continue;

                q.add(new int[] {nextX, nextY});
                miro[nextX][nextY] = miro[locX][locY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}
