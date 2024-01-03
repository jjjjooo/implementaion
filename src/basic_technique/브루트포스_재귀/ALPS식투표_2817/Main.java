package basic_technique.브루트포스_재귀.ALPS식투표_2817;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static int X, N;
    static Staff[] a;
    static int[][] svote;

    public static void main(String[] args) throws IOException {
        input();
        Comparator<Staff> nameComparator = Comparator.comparing(staff -> staff.name);
        Arrays.sort(a, nameComparator);
        for (int i = 0; i < a.length; i++) {
            for(int j = 1; j <= 14; j++){
                svote[i][j] = a[i].vote / j;
            }
        }

        for(int k = 1; k < 15; k++) {
            int idx = 0; int idy = 1;
            for (int i = 0; i < a.length; i++) {
                for (int j = 1; j < 15; j++) {
                    if(svote[idx][idy] < svote[i][j]){
                        idx = i;
                        idy = j;
                    }
                }
            }
            svote[idx][idy] = 0;
            a[idx].plusChip();
        }

        for(int i = 0 ; i < a.length; i++){
            if(a[i].chip == 0 && a[i].vote < (X*0.05)) continue;
            System.out.println(a[i].name + " " + a[i].chip);
        }
    }

    private static void input() {
        X = scan.nextInt();
        N = scan.nextInt();
        a = new Staff[N];
        svote = new int[N][15];

        for (int i = 0; i < N; i++) {
            String name = scan.next();
            int vote = scan.nextInt();
            a[i] = new Staff(name, vote);
        }
    }

    public static class Staff {
        String name;
        int vote;
        int chip;

        public Staff(String name, int vote) {
            this.name = name;
            this.vote = vote;
            this.chip = 0;
        }

        public void plusChip() {
            this.chip += 1;
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
