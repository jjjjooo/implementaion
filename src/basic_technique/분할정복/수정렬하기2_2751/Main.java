package basic_technique.분할정복.수정렬하기2_2751;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] arr;
    static int[] combine;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        combine = new int[N];
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        divide(0, N - 1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
           sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void divide(int start, int end){
        if(start == end) return;
        int mid = (start + end) / 2;
        divide(start, mid);
        divide(mid + 1, end);
        combine(start, end);
    }

    public static void combine(int start, int end){
        int mid  = (start + end) /2;
        int l = start;
        int r = mid + 1;
        int idx = start;

        while(l <= mid && r <= end){
            if(arr[l] < arr[r]){
                combine[idx++] = arr[l++];
            }
            else{
                combine[idx++] = arr[r++];
            }
        }

        while(l <= mid){
            combine[idx++] = arr[l++];
        }
        while(r <= end){
            combine[idx++] = arr[r++];
        }

        for(int i = start; i <= end; i++){
            arr[i] = combine[i];
        }
    }
}
