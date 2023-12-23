package basic_data_structure.리스트.에디터_1406;

import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String origin = sc.next();
        List<Character> list = new LinkedList<>();
        for (char c : origin.toCharArray()) list.add(c);

        int N = sc.nextInt();
        ListIterator<Character> it = list.listIterator(list.size());

        while (N-- > 0) {
            char c = sc.next().charAt(0);
            if (c == 'P') {
                char input = sc.next().charAt(0);
                it.add(input);
            } else if (c == 'L') {
                if (it.hasPrevious())
                    it.previous();
            } else if (c == 'D') {
                if (it.hasNext())
                    it.next();
            } else if (c == 'B') {
                if (it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : list) sb.append(c);
        System.out.println(sb);
    }
}
