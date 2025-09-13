import java.io.*;
import java.util.*;

public class Main {

	static int w, h;// 너비, 높이
	static int[][] map;// 맵
	static int land;// 섬의 개수
	static boolean[][] visited; // 방문
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };// 델타
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };// 델타

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 너비, 높이 입력받
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) // 너비와 높이가 0 이면 루프 종료
				break;

			map = new int[h][w];// 지도 초기화 및 입력받기
			visited = new boolean[h][w];// 방문배열초기화
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			land = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						land++;
					}
				}
			}
			System.out.println(land);
		}
	}

	private static void bfs(int r, int c) {
		// 1. 시작점 방문처리
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		visited[r][c] = true;

		// 2.큐가 빌때까지 반복
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			// 3. 8방향 탐색
			for (int d = 0; d < 8; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				// 4. 범위 안이고아직 방문 안했다면
				if (nr >= 0 && nc >= 0 && nr < h && nc < w && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}

			}

		}

	}
}
