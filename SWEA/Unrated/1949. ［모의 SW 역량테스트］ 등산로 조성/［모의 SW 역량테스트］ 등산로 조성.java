import java.io.*;
import java.util.*;

//0,0 위치에서 시작하여 현재 위치보다 높은곳으로 이동하는 코드 짜보기 ->높은곳에서 내려오자

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

			max = 0; // 봉우리

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}

			ans = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						visited[i][j] = true;
						dfs(i, j, 1, false);
						visited[i][j] = false;
					}
				}
			}
			// 출력 등산로의길이

			System.out.println("#" + tc + " " + ans);

		}
	}

	private static void dfs(int r, int c, int depth, boolean usedK) {
		ans = Math.max(ans, depth);

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < N && nc < N && nr >= 0 && nc >= 0 && !visited[nr][nc]) {
				if (map[nr][nc] < map[r][c]) { // 주변이 나보다 작으면(내려가는길)
					visited[nr][nc] = true;
					dfs(nr, nc, depth + 1, usedK);
					visited[nr][nc] = false;
				} else {
					if (!usedK && map[nr][nc] - K < map[r][c]) {
						int origin = map[nr][nc];
						map[nr][nc] = map[r][c] - 1;
						dfs(nr, nc, depth + 1, true);
						map[nr][nc] = origin;
					}
				}
			}
		}

	}
}
