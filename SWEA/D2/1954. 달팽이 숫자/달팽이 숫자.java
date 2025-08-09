import java.util.*;
import java.io.*;

public class Solution {

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			boolean[][] v = new boolean[N][N];

			int r = 0;
			int c = 0;
			int d = 0;

			for (int i = 1; i <= N * N; i++) {
				arr[r][c] = i;
				v[r][c] = true;

				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc]) {
					d = (d + 1) % 4;
					nr = r + dr[d];
					nc = c + dc[d];
				}
				r = nr;
				c = nc;

			}
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

		}
		
	}
}