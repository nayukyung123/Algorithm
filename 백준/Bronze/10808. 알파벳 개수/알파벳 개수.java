
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int[] cnt = new int[26];

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			int idx = c - 'a';
			cnt[idx]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt.length; i++) {
			sb.append(cnt[i]);
			if (i < 25)
				sb.append(" ");
		}
		System.out.println(sb.toString());

	}

}
