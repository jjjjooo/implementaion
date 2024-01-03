package basic_technique.백트래킹.순열장난_10597;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] used = new int[101];
    static char[] input;
    static int n = 0;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = sc.next().toCharArray();
        n = input.length > 9 ? 9 + (input.length - 9) / 2 : input.length;
        func(0);
    }

    static void func(int idx){
        if(idx >= input.length){
            for(Integer num : answer){
                System.out.print(num + " ");
            }
            System.exit(0);
        }

        int target1 = atoi(input, idx, 1);
        if(target1 <= n && used[target1] == 0){
            used[target1] = idx + 1;
            answer.add(target1);
            func(idx + 1);
            answer.remove(answer.size() - 1);
            used[target1] = 0;
        }

        if(idx + 1 >= input.length) return;

        int target2 = atoi(input, idx, 2);
        if(target2 <= n && used[target2] == 0){
            used[target2] = idx + 1;
            answer.add(target2);
            func(idx + 2);
            answer.remove(answer.size() - 1);
            used[target2] = 0;
        }
    }
    static int atoi(char[] input, int start, int length){
        int result = 0;
        for (int i = start; i < start + length; i++){
            result *= 10;
            result += input[i] - '0';
        }
        return result;
    }
}
