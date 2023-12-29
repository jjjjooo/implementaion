package basic_data_structure.큐.라우터_15828;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        while (true) {
            int info = Integer.parseInt(br.readLine());
            if (info == -1) break;
            if (info == 0) q.poll();
            else {
                if(q.size() >= N) continue;
                q.offer(info);
            }
        }

        if(q.isEmpty()) System.out.println("empty");
        else {
            for(int i = 0; i<N; i++){
                if(q.peek() !=null) bw.write(q.poll() + " ");
            }
            bw.flush();
        }
    }
}
