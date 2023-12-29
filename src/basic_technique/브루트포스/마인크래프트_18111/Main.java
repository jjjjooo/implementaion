package basic_technique.브루트포스.마인크래프트_18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sc = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sc.nextToken());
        int M = Integer.parseInt(sc.nextToken());
        int B = Integer.parseInt(sc.nextToken());

        int[][] ground = new int[N][M];

        int maxH = Integer.MIN_VALUE;
        int minH = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            sc = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int h = Integer.parseInt(sc.nextToken());
                ground[i][j] = h;
                if(h > maxH) maxH = h;
                if(h < minH) minH = h;
            }
        }
        int minT = Integer.MAX_VALUE;
        int foundH = minH;
        for(int i = minH; i <= maxH; i++){
            int calculT = getGrossTime(ground, B, i, N, M);
            if(minT >= calculT){
                foundH = i;
                minT = calculT;
            }
        }

        System.out.println(minT + " " + foundH);
    }

    private static int getGrossTime(int[][] ground, int b, int h, int N, int M) {
        int overHSUm = 0;
        int supplyHSum = 0;
        int grossTime = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(ground[i][j] > h){
                    int block = ground[i][j] - h;
                    overHSUm += block;
                    b += block;

                }
                else supplyHSum += h-ground[i][j];
            }
        }
        if(supplyHSum > b) grossTime = Integer.MAX_VALUE;
        else grossTime = (overHSUm * 2) + supplyHSum;
        return grossTime;
    }
}
