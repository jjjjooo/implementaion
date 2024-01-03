package basic_grahp.기본그래프.소문난칠공주_1941;

/**
 *  크게보기
 *  1. 25명 중 7명을 선택하는 모든 경우의 수를 본다 . 25C7 = 약 50만번
 *  2. 선택한 7명을 탐색한다. DFS-BFS
 *
 *
 *  의식의 흐름
 *  1. 25명 중 7명을 선택하는 조합이다.
 *  1-1. 조합을 풀 것인가? -> 재귀
 *  1-2. 조합을 표현하는 자료구조는 어떻게 되는가 -> 클래스 or 순차번호
 *  1-3. 조합을 표현하는데 있어서 제약 사항이 있는가? -> 1차원 배열의 순차번호와 2차원 배열에서 순차번호는 다르다.
 *
 *  2. 선택한 7명을 어떻게 탐색할 것인가? -> 조건 S>=4 이상이면 탐색을 끝낸다 <- Y와 S 밖에 없기 때문이다.
 *  2.1 탐색은 어떻게 할 것인가? -> DFS, BFS 둘다 가능해보임
 *
 */

import java.util.Scanner;

public class Main {

    static int[] person = new int[25];
    static boolean[] check = new boolean[25];

    static boolean[] visited = new boolean[25];
    static int[] seven = new int[7];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            String next = sc.next();
            for (int j = 0; j < 5; j++) {
                if (next.charAt(j) == 'Y')
                    person[cnt++] = 0;
                else person[cnt++] = 1;
            }
        }
        combination(0, 0, 0);
        System.out.println(ans);
    }

    static int ans = 0;

    static void combination(int depth, int start, int sCnt) {
        if (depth == 7) {
            if (sCnt >= 4) {
                    if (dfs(seven[0]) == 7) {
                    ans++;
                }
                for (int i = 0; i < 25; i++) {
                    if(visited[i]) visited[i] = false;
                }
            } else return;
            return;
        }
        for (int i = start; i < 25; i++) {
            if (!check[i]) {
                check[i] = true;
                seven[depth] = i;
                combination(depth + 1, i + 1, person[i] == 1 ? sCnt + 1 : sCnt);
                seven[depth] = -1;
                check[i] = false;
            }
        }
    }

    private static int dfs(int person) {
        int cnt = 1;
        visited[person] = true;
        int now = person;
        for (int i = 1; i < 7; i++) {
            int op = seven[i];
            if (!visited[seven[i]] && isNext(now, op)) {
                cnt += dfs(seven[i]);
            }
        }
        return cnt;
    }

    static boolean isNext(int a, int b) {
        int diff = Math.abs(a - b);
        int max = Math.max(a, b);
        if (diff == 1 && max % 5 != 0) return true;
        if (diff == 5) return true;
        return false;
    }
}
