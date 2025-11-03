
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int[] dr = { 0, 1, 1, -1 };
	static int[] dc = { 1, 0, 1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			char[][] board = new char[n][n];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {
					board[i][j] = line.charAt(j);
				}

			}

			boolean isO = false;
			int cnt = 0;

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {

					for (int d = 0; d < 4; d++) {
						cnt = 0;
						for (int step = 0; step < 5; step++) {
							int nr = r + dr[d] * step;
							int nc = c + dc[d] * step;

							if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
								if (board[nr][nc] == 'o') {
									cnt++;
								} else break;
								if (cnt >= 5) {
									isO = true;
									break;
								}

							}
						}
					}

				}
			}

			// 출력
			if (isO) {
				System.out.println("#" + tc + " " + "YES");
			} else {
				System.out.println("#" + tc + " " + "NO");
			}

		}
	}
}
