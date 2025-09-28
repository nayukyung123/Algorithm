import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int cnt;
	static int maxCnt;
	static int[][] cheese;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			cheese = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxCnt = 0;
			for (int day = 0; day < 100; day++) {
				visited = new boolean[N][N];
				cnt = 0;

				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (day == cheese[i][j]) {
							cheese[i][j] = 0;
						}
					}
				}// 치즈먹기

				
				for (int i = 0; i < cheese.length; i++) {
					for (int j = 0; j < cheese.length; j++) {
						if (!visited[i][j] && cheese[i][j] != 0) {
							dfs(i, j);
							cnt++;
						}
					}
				}// 치즈덩어리세기
				
				maxCnt = Math.max(maxCnt, cnt); // 치즈 덩어리 최대값 갱신 
			}
			System.out.println("#" + tc + " " + maxCnt);
		}
	}

	private static void dfs(int i, int j) {
		visited[i][j] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && cheese[nr][nc] != 0) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}

		}
	}
}
