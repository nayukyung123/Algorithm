import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 색상 순서 배열
        String[] color = {
            "black", "brown", "red", "orange", "yellow",
            "green", "blue", "violet", "grey", "white"
        };

        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();  // 첫 번째 색
        String b = sc.nextLine();  // 두 번째 색
        String c = sc.nextLine();  // 세 번째 색

        int x = -1, y = -1, z = -1;

        //  색 인덱스 찾기
        for (int i = 0; i < color.length; i++) {
            if (color[i].equals(a)) x = i;
            if (color[i].equals(b)) y = i;
            if (color[i].equals(c)) z = i;
        }

        // 앞의 두 숫자(a, b) 합치기
        long value = Long.parseLong("" + x + y);
        long result = value * (long)Math.pow(10, z);

        System.out.println(result);
    }
}