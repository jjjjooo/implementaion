package basic_data_structure.스택.PPAP_16120;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] str = sc.next().toCharArray();
        char[] ppap = new char[str.length];
        int idx = 0;
        for (int i = 0; i < str.length; i++) {
            ppap[idx++] = str[i];
            if (idx >= 4 && ppap[idx-1] == 'P' && ppap[idx - 2] == 'A'
                    && ppap[idx - 3] == 'P' && ppap[idx - 4] == 'P'){
                idx -= 3;
                ppap[idx] = 'P';
            }

        }
        System.out.println(idx == 1 && ppap[0] == 'P' ? "PPAP" : "NP");
    }
}
