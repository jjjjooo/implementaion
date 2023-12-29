package basic_data_structure.스택.외게인의기타연주_2841;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] topIds = new int[7];
        Arrays.fill(topIds, -1);
        int[][] melody = new int[7][P];
        int cnt = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int plat = Integer.parseInt(st.nextToken());

            while (topIds[line] >= 0) {
                if (melody[line][topIds[line]] > plat) {
                    topIds[line]--;
                    cnt++;
                } else break;
            }
            if (topIds[line] >= 0 && melody[line][topIds[line]] == plat) continue;

            melody[line][++topIds[line]] = plat;
            cnt++;
        }
        System.out.println(cnt);
    }
}

