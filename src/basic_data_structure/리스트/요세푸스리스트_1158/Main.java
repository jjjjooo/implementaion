package basic_data_structure.리스트.요세푸스리스트_1158;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int K = sc.nextInt();

        LinkedList<Integer> arr = new LinkedList<>();
        for(int i = 1; i<=N; i++) arr.add(i);

        bw.write("<");
        K = K - 1;
        int start = 0;
        for (int i = 0; i<N; i++){
            int preSize = arr.size();
            int next = (start + K) % preSize;
            int ans = arr.remove(next);
            start = next;

            if(i == N - 1) bw.write(ans+"");
            else bw.write(ans + ", ");
        }
        bw.write(">");
        bw.flush();
    }
}
