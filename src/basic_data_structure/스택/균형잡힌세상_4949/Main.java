package basic_data_structure.스택.균형잡힌세상_4949;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            char[] line = sc.nextLine().toCharArray();
            if (line.length == 1 && line[0] == '.') break;

            int topIdx = -1;
            char[] open = new char[line.length];
            boolean isValid = true;
            for (char c : line) {
                if (c == '(' || c == '[') {
                    open[++topIdx] = c;
                }
                else if (c == ')' || c == ']') {
                    if (topIdx < 0 || !isMatch(c, open[topIdx--])) {
                        isValid = false;
                        break;
                    }
                }
            }
            if(topIdx >= 0) isValid = false;
            System.out.println(isValid ? "yes" : "no");
        }
    }

    private static boolean isMatch(char c, char match) {
        if (match == '(' && c == ')') {
            return true;
        }
        if (match == '[' && c == ']') {
            return true;
        }
        return false;
    }
}
