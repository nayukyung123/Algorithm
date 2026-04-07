import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[][] map;
	static int R, C;
	static boolean[] visited = new boolean[26];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		visited[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(max);

	}

	private static void dfs(int r, int c, int cnt) {
		max = Math.max(cnt, max);

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if (visited[map[nr][nc] - 'A'] != true) {
					visited[map[nr][nc] - 'A'] = true;
					dfs(nr, nc, cnt + 1);
					visited[map[nr][nc] - 'A'] = false;
				}
			}
		}
		
	}

}
