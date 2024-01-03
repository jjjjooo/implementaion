package basic_technique.브루트포스_재귀.사탕게임_3085;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    public static void main(String[] args) throws IOException {
        input();
        func();
    }

    static int N;
    static char[][] map;

    private static void func() {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && map[i][j] != map[i][j + 1]){
                    swapLoc(i,j, i,j+1);
                    ans = Math.max(ans, Math.max(maxColCount(), maxRowCount()));
                    swapLoc(i, j, i,  j+1);
                }

                if (i + 1 < N && map[i][j] != map[i+1][j]){
                    swapLoc(i,j, i+1,j);
                    ans = Math.max(ans, Math.max(maxColCount(), maxRowCount()));
                    swapLoc(i, j, i+1,  j);
                }
            }
        }
        System.out.println(ans);
    }

    private static void swapLoc(int xi, int xj, int ci, int cj) {
        char temp  = map[xi][xj];
        map[xi][xj] = map[ci][cj];
        map[ci][cj] = temp;
    }

    private static int maxRowCount(){
        int maxRow = 0;
        for(int i = 0; i < N; i++){
            int len = 1;
            for(int c = 1; c < N; c++){
                if(map[i][c] == map[i][c-1]) len++;
                else {
                    maxRow = Math.max(maxRow, len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow, len);
        }
        return maxRow;
    }

    private static int maxColCount(){
        int maxCol = 0;
        for(int i = 0; i < N; i++){
            int len = 1;
            for(int j = 1; j < N; j++){
                if(map[j][i] == map[j-1][i]) len++;
                else {
                    maxCol = Math.max(maxCol, len);
                    len = 1;
                }
            }
            maxCol = Math.max(maxCol, len);
        }
        return maxCol;
    }

    private static void input() throws IOException {
        N = scan.nextInt();
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = scan.next().toCharArray();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
