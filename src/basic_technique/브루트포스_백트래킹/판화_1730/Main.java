package basic_technique.브루트포스_백트래킹.판화_1730;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    public static void main(String[] args) throws IOException {
        input();
        func();
    }

    static int N, row = 0, col = 0;
    static String move;
    static boolean[][] vertical;
    static boolean[][] horizon;

    private static void func() {
        for (int i = 0; i < move.length(); i++) {
            char c = move.charAt(i);
            if (c == 'D') {
                if (row == N - 1) continue;
                vertical[row][col] = vertical[row + 1][col] = true;
                row++;
            } else if (c == 'U') {
                if (row == 0) continue;
                vertical[row][col] = vertical[row - 1][col] = true;
                row--;
            } else if (c == 'R') {
                if (col == N - 1) continue;
                horizon[row][col] = horizon[row][col + 1] = true;
                col++;
            } else  {
                if (col == 0) continue;
                horizon[row][col] = horizon[row][col - 1] = true;
                col--;
            }
        }
        for (int i = 0; i < N; i++) {
            String ans = "";
            for (int j = 0; j < N; j++) {
                if(vertical[i][j] && horizon[i][j]) ans += "+";
                else if (vertical[i][j]) ans += "|";
                else if (horizon[i][j]) ans += "-";
                else ans += ".";
            }
            System.out.println(ans);
        }
    }


    private static void input() throws IOException {
        N = scan.nextInt();
        move = scan.next();
        vertical = new boolean[N][N];
        horizon = new boolean[N][N];
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
                    String inputLine = br.readLine();
                    if (inputLine == null) {
                        // 입력이 없을 경우, 빈 문자열("") 반환
                        return "";
                    }
                    st = new StringTokenizer(inputLine);
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
