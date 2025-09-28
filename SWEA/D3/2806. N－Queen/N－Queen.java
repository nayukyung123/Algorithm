import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int ans;
	static boolean[] usedRow;
	static boolean[] usedDiag1;
	static boolean[] usedDiag2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			usedRow = new boolean[N];
			usedDiag1 = new boolean[2 * N - 1];
			usedDiag2 = new boolean[2 * N - 1];

			ans = 0;
			dfs(0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void dfs(int col) {
		if (col == N) {
			ans++;
			return;
		}
		for (int row = 0; row < N; row++) {
			if (usedRow[row] || usedDiag1[row + col] || usedDiag2[col - row + N - 1])
				continue;
			
			usedRow[row] = true;
			usedDiag1[row + col] = true;
			usedDiag2[col - row + N - 1]=true;
			
			dfs(col+1);
			
			usedRow[row] = false;
			usedDiag1[row + col] = false;
			usedDiag2[col - row + N - 1]=false;
			
		}
	}

}
