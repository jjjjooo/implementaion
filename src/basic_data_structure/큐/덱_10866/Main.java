package basic_data_structure.큐.덱_10866;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();

        while(N-- > 0){
            String[] cmd = br.readLine().split(" ");
            if(cmd[0].equals("push_front")){
                dq.offerFirst(Integer.valueOf(cmd[1]));
            } else if (cmd[0].equals("push_back")) {
                dq.offerLast(Integer.valueOf(cmd[1]));
            } else if(cmd[0].equals("pop_front")){
                bw.append(dq.isEmpty() ? "-1\n" : dq.pollFirst() + "\n");

            } else if(cmd[0].equals("pop_back")){
                bw.append(dq.isEmpty() ? "-1\n" : dq.pollLast() + "\n");
            } else if(cmd[0].equals("size")){
                bw.append(dq.size() + "\n");
            } else if(cmd[0].equals("empty")){
                bw.append(dq.isEmpty() ? "1\n" : "0\n");
            } else if(cmd[0].equals("front")){
                bw.append(dq.isEmpty() ? "-1\n" : dq.getFirst() + "\n");
            } else if(cmd[0].equals("back")){
                bw.append(dq.isEmpty() ? "-1\n" : dq.getLast() + "\n");
            }
        }
        bw.flush();
    }
}
