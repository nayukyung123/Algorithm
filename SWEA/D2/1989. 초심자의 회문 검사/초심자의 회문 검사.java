import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String s = sc.next();
			int ans = 1;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
					ans = 0;
					break;
				}
			}
			System.out.println("#" + tc + " " + ans);

		}

	}

}