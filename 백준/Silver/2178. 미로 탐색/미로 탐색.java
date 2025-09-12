import java.io.*;
import java.util.*;

//BFS
//최소 칸 수 -> 가장 가까운 경로 먼저 탐색
public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}

		}

		bfs(0, 0);

	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[N][M];

		visited[i][j] = true;
		q.offer(new int[] { i, j });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];

			if (r == N - 1 && c == M - 1) {
				System.out.println(map[r][c]);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
					if (!visited[nr][nc] && map[nr][nc] == 1) {
						visited[nr][nc] = true;
						map[nr][nc] = map[r][c] + 1;
						q.offer(new int[] { nr, nc });
					}
				}

			}

		}
	}
}

// 1. Queue<int[]> 생성
// 2. visited[N][M] 배열 선언
// 3. 시작점 큐에 넣고 visited true
// 4. while문으로 큐 빌 때까지:
//    - 현재 좌표 꺼내기
//    - 도착점(N-1,M-1)이면 map[r][c] 출력 후 return
//    - 4방향 탐색 (dr,dc 사용)
//      - 범위 안 / 방문 안함 / map이 1이면:
//        - visited true
//        - map[nr][nc] = map[r][c] + 1
//        - 큐에 넣기