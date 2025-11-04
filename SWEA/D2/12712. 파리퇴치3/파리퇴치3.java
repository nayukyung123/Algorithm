import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] dirR = { -1, -1, 1, 1 };
	static int[] dirC = { -1, 1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 크기
			int m = Integer.parseInt(st.nextToken()); // 스프레이 분사

			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 스프레이 뿌리자
			// + 모양
			int sumPlus = 0;
			int sumX = 0;
			int max = 0;

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					sumPlus = arr[r][c];
					sumX = arr[r][c];
					// + 모양
					for (int d = 0; d < 4; d++) {
						for (int M = 1; M < m; M++) {
							int nr = r + dr[d] * M;
							int nc = c + dc[d] * M;

							if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
								sumPlus += arr[nr][nc];
							}

						}
					}

					// x 모양
					for (int d = 0; d < 4; d++) {
						for (int M = 1; M < m; M++) {
							int nr = r + dirR[d] *M;
							int nc = c + dirC[d] * M;

							if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
								sumX += arr[nr][nc];
							}

						}
					}
					max = Math.max(max, Math.max(sumPlus, sumX));

				}
			}

			System.out.println("#" + tc + " " + max);

		}
	}
}
