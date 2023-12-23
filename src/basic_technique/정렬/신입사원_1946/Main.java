package basic_technique.정렬.신입사원_1946;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader sc = new FastReader();
    public static void main(String[] args) {

        int T = sc.nextInt();

        while(T-- > 0){
            int N = sc.nextInt();
            Employee[] employees = new Employee[N];
            for(int i = 0; i < N; i++){
                int f = sc.nextInt();
                int s = sc.nextInt();
                employees[i] = new Employee(i,f,s);
            }

            Arrays.sort(employees);

            int cnt = 1;
            int minSecond = employees[0].second;
            for (int i = 1; i<N; i++){
                if(employees[i].second < minSecond){
                    minSecond = employees[i].second;
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

    }

    static class Employee implements Comparable<Employee>{
        private int idx;
        private int first;
        private int second;

        public Employee(int idx, int first, int second) {
            this.idx = idx;
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Employee o) {
            return this.first - o.first;
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
    }
}
