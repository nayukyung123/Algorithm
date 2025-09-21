import java.io.*;
import java.util.*;

public class Solution {

	static int ans;
	static int[][] map = new int[16][16];
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();

			for (int i = 0; i < 16; i++) {
				String line = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}

			// 갈수있음 1
			// 갈수없음 0
			// 전부 가야함
			ans = 0;
			visited = new boolean[16][16];
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					if (map[i][j] == 2) {
						visited[i][j] = true;
						bfs(i, j);
					}
				}
			}
			System.out.println("#" + tc + " " + ans);

		}
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];

			if (map[r][c] == 3) {
				ans = 1;
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 16 && nc < 16 && nr >= 0 && nc >= 0 && !visited[nr][nc] && map[nr][nc] != 1) {
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });

				}
			}
		}

	}
}