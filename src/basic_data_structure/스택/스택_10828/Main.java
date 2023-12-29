package basic_data_structure.스택.스택_10828;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        while (N-- > 0) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("push")) {
               stack.addLast(Integer.valueOf(cmd[1]));
            } else if (cmd[0].equals("pop")) {
                if (stack.isEmpty()) bw.write("-1\n");
                else bw.write(stack.removeLast() + "\n");
            } else if (cmd[0].equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (cmd[0].equals("empty")) {
                bw.write(stack.isEmpty() ? "1\n"  : "0\n");
            } else if (cmd[0].equals("top")) {
                if (stack.isEmpty()) bw.write("-1\n");
                else bw.write(stack.getLast() + "\n");
            }
            bw.flush();
        }
    }
}
