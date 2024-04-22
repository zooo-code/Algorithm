import java.io.IOException;
import java.util.*;

public class test {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String s = scanner.nextLine();
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        int m = Integer.parseInt(scanner.nextLine());
        int cursor = s.length();

        for (int i = 0; i < m; i++) {
            String[] a = scanner.nextLine().split(" ");
            char cmd = a[0].charAt(0);
            if (cmd == 'P') {
                char ch = a[1].charAt(0);
                list.add(cursor, ch);
                cursor++;
            } else if (cmd == 'L') {
                if (cursor > 0) cursor--;
            } else if (cmd == 'D') {
                if (cursor < list.size()) cursor++;
            } else {
                if (cursor > 0) {
                    list.remove(cursor - 1);
                    cursor--;
                }
            }
        }

        for (char c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
