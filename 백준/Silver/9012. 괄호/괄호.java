import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        for (int i = 0; i < arr.length; i++) {
            int count1 = 0; // 여는 괄호
            int count2 = 0; // 닫는 괄호
            boolean valid = true;

            for (int j = 0; j < arr[i].length(); j++) {
                char c = arr[i].charAt(j); // 문자열의 각 문자 확인
                if (c == '(') {
                    count1++;
                } else {
                    count2++;
                }

                if (count2 > count1) { // 닫는 괄호가 먼저 나오면 실패
                    valid = false;
                    break;
                }
            }

            if (valid && count1 == count2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}