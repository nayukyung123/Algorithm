import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int result = 0;

		for (int tc = 1; tc <= T; tc++) {
			String word = sc.next();
			boolean[] visited = new boolean[26]; // 방문처리보관소
			boolean isGroup = true;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (i > 0 && c != word.charAt(i - 1)) {
					if (visited[c - 'a']) {
						isGroup = false;
						break;
					}
				}
				visited[c - 'a'] = true;
			}

			if (isGroup)
				result++;

		}
		System.out.println(result);
	}
}
