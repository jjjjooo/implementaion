package basic_data_structure.큐.프린터큐_1966;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader sc = new FastReader();
    public static void main(String[] args) throws IOException {

        int T = sc.nextInt();

        while(T-- > 0){
            int N = sc.nextInt();
            int M = sc.nextInt();

            Queue<Doc> q = new LinkedList<>();
            Integer[] priority = new Integer[N];
            for (int i = 0; i < N; i++) {
                priority[i] = sc.nextInt();
                q.offer(new Doc(i, priority[i]));
            }
            Arrays.sort(priority, Collections.reverseOrder());
            for (int i = 0; i < N; i++){
                while(q.peek().priority != priority[i])
                    q.offer(q.poll());
                if(q.peek().idx == M){
                    System.out.println(i+1);
                    break;
                }
                q.poll();
            }
        }
    }

    public static class Doc{
        int idx;
        int priority;

        public Doc(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public Integer nextInt(){
            return Integer.valueOf(next());
        }
    }
}
