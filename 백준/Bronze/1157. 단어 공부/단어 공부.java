import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next().toUpperCase();
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'A']++;  // 알파벳  -> int
		}
		int max = 0;
		char result = '?'; //char = 문자 한 개 , String 문자 여러 개 

		for (int i = 0; i < count.length; i++) {
			if (count[i] > max) {
				max = count[i];
				result = (char) (i + 'A'); // int -> 알파벳
			} else if (max == count[i]) {
				result = '?';
			}
		}
		System.out.println(result);

	}

}
