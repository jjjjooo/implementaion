package basic_grahp.기본그래프.숨박꼭질_1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, K;
    static int[] visited = new int[100001];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();


        System.out.println(BFS()-1);
    }

    static int cnt = Integer.MAX_VALUE;
    private static int BFS() {
        q.offer(N);
        visited[N] = 1;

        while (!q.isEmpty()) {
            Integer now = q.poll();
            if(now == K){
                cnt = Math.min(cnt, visited[now]);

            }
            for(int i = 0 ; i < 3; i++){
                if(i == 0) {
                    if(now > 0 && visited[now - 1] == 0) {
                        q.offer(now - 1);
                        visited[now - 1] = visited[now] + 1;
                    }

                } else if (i == 1) {
                    if(now <= 99999 && visited[now + 1] == 0) {
                        q.offer(now + 1);
                        visited[now + 1] = visited[now] + 1;
                    }
                }
                else {
                    if(now <=50000 && visited[now * 2] == 0) {
                        q.offer(now * 2);
                        visited[now * 2] = visited[now] + 1;
                    }
                }
            }
        }
        return cnt;
    }
}
