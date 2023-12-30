package 기타.구현.방번호_1475;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] number = sc.next().toCharArray();

        int[] numbers = new int[10];

        for (int i = 0; i < number.length; i++) {
            char c = number[i];
            numbers[c - '0']++;

        }
        int cnt = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(i == 6 || i == 9) continue;
            if (cnt < numbers[i]) {
                cnt = numbers[i];

            }
        }
        cnt = Math.max(((numbers[6] + numbers[9]) + 1) / 2, cnt);

        System.out.println(cnt);
    }
}
