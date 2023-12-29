package basic_data_structure.스택.옥상정원꾸미기_6198;

import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Building[] buildings = new Building[n+1];

        for (int i = 1; i <= n; i++){
            buildings[i] = new Building(i,Integer.parseInt(br.readLine()));
        }

        int top = -1;
        Building[] bStack = new Building[n];
        for (int i = n; i >= 1; i--){
            int cnt = 0;
            while(top >= 0 && bStack[top].h < buildings[i].h){
                cnt += bStack[top].view;
                top--;
                cnt++;
            }
            bStack[++top] = buildings[i].setView(cnt);
        }
        long sum = 0;
        for(int i = 1; i<=n; i++)
            sum += buildings[i].view;
        System.out.println(sum);
    }

    static class Building{
        int idx;
        int h;
        int view;

        public Building setView(int view) {
            this.view = view;
            return this;
        }

        public Building(int idx, int h) {
            this.idx = idx;
            this.h = h;
            this.view = 0;
        }
    }
}
