package basic_data_structure.큐.AC_5430;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String op = br.readLine();
            int n = Integer.parseInt(br.readLine());


            String[] split = br.readLine().replaceAll("\\[|\\]", "").split(",");

            int[] arr = new int[n];
            int front = 0, rear = -1;
            for(int i = 0; i < n; i++){
                arr[++rear] = Integer.parseInt(split[i]);
            }
            int size = n;
            boolean revers = false;
            boolean error = false;
            for(int i = 0; i<op.length(); i++){
                if(op.charAt(i) == 'R'){
                    int temp = rear;
                    rear = front;
                    front = temp;
                    revers = (revers) ? false : true;
                }
                else {
                    if(size == 0 || n == 0){
                        error = true;
                        break;
                    }
                    if (revers){
                        arr[front] = -1;
                        front = (front -1 + n) % n;
                    }else {
                        arr[front] = -1;
                        front = (front + 1) % n;
                    }
                    size--;
                }
            }
            if(error){
                System.out.println("error");
                continue;
            }
            bw.append("[");
            if(revers) {
                for (int i = front; i >= rear; i--) {
                    if(arr[front] == -1) continue;
                    if (i == rear) bw.append(arr[i] + "");
                    else bw.append(arr[i] + ",");
                }
            } else {
                for(int i = front; i<= rear; i++){
                    if(arr[front] == -1) continue;
                    if (i == rear) bw.append(arr[i] + "");
                    else bw.append(arr[i] + ",");
                }
            }
            bw.append("]\n");
            bw.flush();
        }
    }
}
