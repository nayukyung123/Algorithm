import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				int k = sc.nextInt();

				for (int j = 0; j < k; j++) {
					sb.append(s);
				}
			}

			System.out.println("#" + tc);
			String result = sb.toString();
			for (int i = 0; i < result.length(); i++) {
				System.out.print(result.charAt(i));
				if ((i + 1) % 10 == 0) {
					System.out.println();
				}
			}System.out.println();

		}

	}

}