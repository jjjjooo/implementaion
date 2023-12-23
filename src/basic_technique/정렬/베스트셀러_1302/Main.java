package basic_technique.정렬.베스트셀러_1302;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] titles = new String[n];
        for (int i = 0; i < n; i++) {
            titles[i] = sc.next();
        }

        Arrays.sort(titles);

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String title : titles) {
            map.put(title, map.getOrDefault(title,0) + 1);
        }
        Integer max = Integer.MIN_VALUE;
        String best = "";
        for (String key : map.keySet()){
            if(map.get(key) > max){
                best = key;
                max = map.get(key);
            }
        }
        System.out.println(best);
    }
}
