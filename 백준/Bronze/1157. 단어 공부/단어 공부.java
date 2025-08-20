import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next().toUpperCase(); // 대소문자 구분X → 전부 대문자로 변환
        int[] count = new int[26]; // A~Z 개수 저장

        // 각 알파벳 등장 횟수 세기
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            count[c - 'A']++;
        }

        // 최댓값 찾기
        int max = 0;
        char answer = '?';
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                answer = (char) (i + 'A');
            } else if (count[i] == max) {
                answer = '?'; // 최댓값이 같은 경우
            }
        }

        System.out.println(answer);
    }
}