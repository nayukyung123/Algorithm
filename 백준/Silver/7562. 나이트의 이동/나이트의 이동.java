import java.io.*;
import java.util.*;

public class Main {
	static int l;
	static boolean[][] visited;
	static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			l = Integer.parseInt(br.readLine());
			visited = new boolean[l][l];

			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int tr = Integer.parseInt(st.nextToken());
			int tc = Integer.parseInt(st.nextToken());

			int ans = bfs(sr, sc, tr, tc);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int sr, int sc, int tr, int tc) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(sr, sc, 0));
		visited[sr][sc] = true;

		while (!q.isEmpty()) {

			Point cur = q.poll();
			if (cur.r == tr && cur.c == tc) {
				return cur.cnt;
			}

			for (int d = 0; d < 8; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (nr >= 0 && nc >= 0 && nr < l && nc < l && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new Point(nr, nc, cur.cnt + 1));
				}
			}
		}
		return -1;
	}
}
