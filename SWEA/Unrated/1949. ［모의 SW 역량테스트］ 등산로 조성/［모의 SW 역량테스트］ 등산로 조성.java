import java.io.*;
import java.util.*;

public class Solution {

	static int N, K, ans, max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(max, map[i][j]);

				}
			}

			visited = new boolean[N][N];
			ans = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						visited[i][j] = true;
						dfs(i, j, 1, false);
						visited[i][j] = false;
					}

				}
			}
			System.out.println("#" + tc + " " + ans);

		}
	}

	private static void dfs(int r, int c, int len, boolean cutUsed) {
		ans = Math.max(ans, len);

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) {
			    continue;
			}

			if (map[nr][nc] < map[r][c]) {
				visited[nr][nc] = true;
				dfs(nr, nc, len + 1, cutUsed);
				visited[nr][nc] = false;
			} else if (!cutUsed) {
				for (int cut = 1; cut <= K; cut++) {
					if(map[nr][nc] -cut < map[r][c]) {
						map[nr][nc] -= cut;
						visited[nr][nc] = true;
						dfs(nr, nc, len + 1, true);
						visited[nr][nc] = false;
						map[nr][nc] += cut;
					}
				}
			}

		}

	}

}
