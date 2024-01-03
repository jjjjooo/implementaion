package basic_grahp.기본그래프.빙산_2573;
/**
 * 컴퓨팅 사고
 * 1. 녹이면서 진행하기 어렵다 -> 다음 얼음이 영향을 받는다.
 *
 * 기법
 * 1. 구조체를 활용하여 동시 업데이트, 동시 기록을 처리할 수 있다. -> 공간복잡도 up
 * 2. ArrayList 삭제 연산2 -> 마지막을 현재에 끼워놓고 마지막을 삭제하고 사이즈를 줄인다.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    static int n,m;
    static int[][] map;
    static List<Ice> iceList = new ArrayList<>();
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0 , -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n][m];

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] > 0) iceList.add(new Ice(i, j, map[i][j]));
                visited[i][j] = true;
            }
        }
        int year = 1;
        while(!iceList.isEmpty()){


            for(Ice ice : iceList){
                for(int i = 0; i < 4; i++){
                    int nr = ice.row + dr[i];
                    int nc = ice.col + dc[i];
                    if(map[nr][nc] == 0) ice.height--;
                }
            }

            for(int i = 0; i < iceList.size(); i++){
                Ice ice = iceList.get(i);
                if(ice.height <= 0){
                    map[ice.row][ice.col] = 0;
                    iceList.set(i, iceList.get(iceList.size()-1));
                    iceList.remove(iceList.size() -1);
                    i--;
                }
                else {
                    visited[ice.row][ice.col] = false;
                }
            }

            if (!iceList.isEmpty() && dfs(iceList.get(0).row, iceList.get(0).col) != iceList.size()) {
                System.out.println(year);
                System.exit(0);
            }
            year++;
        }
        System.out.println(0);
    }

    static int dfs(int row, int col){
        visited[row][col] = true;
        int cnt = 1;
        for(int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            if (visited[nr][nc]) continue;
            cnt += dfs(nr, nc);
        }
        return cnt;
    }

    static class Ice{
        int row;
        int col;
        int height;

        public Ice(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
