package basic_technique.정렬.단어정렬_1181;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(strList,  new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });
        System.out.println(strList[0]);
        for (int i = 1; i < N; i++){
            if(!strList[i].equals(strList[i-1]))
                System.out.println(strList[i]);
        }
    }


    static int N;
    static String[] strList;
    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        strList = new String[N];
        for(int i = 0; i < N; i++){
            String str = sc.next();
            strList[i] = str;
        }
    }
}
