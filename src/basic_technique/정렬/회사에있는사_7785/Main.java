package basic_technique.정렬.회사에있는사_7785;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Check[] checkList = new Check[n];
        for(int i=0; i<n; i++){
            String name = sc.next();
            String status = sc.next();
            checkList[i] = new Check(name, status);
        }

        Arrays.sort(checkList);

        Map<String, String> map = new LinkedHashMap<>();
        for(Check check : checkList){
            map.put(check.name, check.status);
        }
        for(String key : map.keySet()){
            String status = map.get(key);
            if(status.equals("leave")) continue;
            System.out.println(key);
        }
    }

    public static class Check implements Comparable<Check>{
        String name;
        String status;

        public Check(String name, String status) {
            this.name = name;
            this.status = status;
        }

        @Override
        public int compareTo(Check o) {
            return o.name.compareTo(name);
        }
    }
}
