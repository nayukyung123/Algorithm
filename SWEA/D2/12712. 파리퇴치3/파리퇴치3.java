import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] drPlus = { -1, 1, 0, 0 };
	static int[] dcPlus = { 0, 0, -1, 1 };
	static int[] drX = { -1, -1, 1, 1 };
	static int[] dcX = { -1, 1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int sumPlus = 0;
			int sumX = 0;
			int max = 0;

			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map.length; c++) {
					sumPlus = map[r][c];
					sumX = map[r][c];

					// + 모양
					for (int d = 0; d < 4; d++) {
						for (int m = 1; m < M; m++) {
							int nr = r + drPlus[d] * m;
							int nc = c + dcPlus[d] * m;

							if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
								sumPlus += map[nr][nc];
							}

						}

					}

					// x 모양
					for (int d = 0; d < 4; d++) {
						for (int m = 1; m < M; m++) {
							int nr = r + drX[d] * m;
							int nc = c + dcX[d] * m;

							if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
								sumX += map[nr][nc];
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
