import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {

	static int[][] cheese; // 치즈
	static int N; // 한변의 길이
	static int max; // 치즈 최대 갯수
	static int cheeseCnt; // 실시간 치즈 카운트
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine()); // 한변의 길이 입력받음

			cheese = new int[N][N]; // 치즈 배열 초기화
			int maxCheese = 0; // 입력 치즈 값 중 최대값
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					maxCheese = Math.max(maxCheese, cheese[i][j]);
				}
			} // 치즈 완성

			// ->0 ~ maxCheese일 진행
			max = 0;
			for (int day = 0; day <= maxCheese; day++) {
				visited = new boolean[N][N];
				cheeseCnt = 0; // 하루 마다 덩어리 세야하니까 day 반복문 에서 초기화

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (day == cheese[i][j]) {
							cheese[i][j] = 0;
						}
					}
				} // 치즈 먹기

				for (int i = 0; i < cheese.length; i++) {
					for (int j = 0; j < cheese.length; j++) {
						if (!visited[i][j] && cheese[i][j] != 0) {
							dfs(i, j);
							cheeseCnt++;
						}
					}
				} // 치즈 덩어리 세기
				max = Math.max(max, cheeseCnt); // 치즈 덩어리 최대값 갱신
			}
			System.out.println("#" + tc + " " + max);
		}
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && cheese[nr][nc] != 0) {
				dfs(nr, nc);
			}
		}
	}
}
