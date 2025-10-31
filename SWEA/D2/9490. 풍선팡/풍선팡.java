import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 가
			int m = Integer.parseInt(st.nextToken()); // 세

			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = Integer.MIN_VALUE;// 꽃가루 수 중 최대값

			// 상하좌우더한값
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {

					int flower = map[r][c];
					int sum = flower;

					for (int d = 0; d < 4; d++) {
						for (int i = 1; i <= flower; i++) {
							int nr = r + dr[d] * i;
							int nc = c + dc[d] * i;

							if (nr >= 0 && nc >= 0 && nr < n && nc < m)
								sum += map[nr][nc];
						}

					}
					max = Math.max(max, sum);
				}
			}
			System.out.println("#" + tc + " " + max);

		}
	}
}