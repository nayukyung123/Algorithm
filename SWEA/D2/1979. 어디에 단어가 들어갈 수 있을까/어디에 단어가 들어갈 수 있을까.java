import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int ans = 0;

			// r
			for (int r = 0; r < n; r++) {
				int cnt = 0;
				for (int c = 0; c < n; c++) {
					if (map[r][c] == 1)
						cnt++;
					else {
						if (cnt == k) {
							ans++;
						}
						cnt = 0;
					}

				}
				if (cnt == k) {
					ans++;
				}
			}

			// c
			for (int r = 0; r < n; r++) {
				int cnt = 0;
				for (int c = 0; c < n; c++) {
					if (map[c][r] == 1) {
						cnt++;
					} else {
						if (cnt == k) {
							ans++;
						}
						cnt = 0;
					}
				}
				if (cnt == k) {
					ans++;
				}
			}

			System.out.println("#" + tc + " " + ans);

		}

	}
}
