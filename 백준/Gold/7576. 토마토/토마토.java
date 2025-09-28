import java.io.*;
import java.util.*;

//토마토 
public class Main {

	static int M, N, ans;
	static int[][] box;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M]; // 박스초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		bfs();// 토마토익히기

		// 토마토익히고 박스확인
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) { // 익지않은게 있다면
					ans = -1;
					System.out.println(ans);
					return;
				}
				ans = Math.max(ans, box[i][j]);
			}

		}
		System.out.println(ans - 1);

	}

	private static void bfs() {
		// 익은 토마토를 전부 큐에 넣음
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1)
					q.offer(new int[] { i, j });
			}
		}

		// 익은 토마토들이 사방에서 익는 중
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int sr = cur[0];
			int sc = cur[1];

			for (int d = 0; d < 4; d++) {
				int nr = sr + dr[d];
				int nc = sc + dc[d];

				// 익어있지않다면
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && box[nr][nc] == 0) {
					box[nr][nc] = box[sr][sc] + 1;
					q.offer(new int[] { nr, nc });
				}
			}
		}

	}

}
