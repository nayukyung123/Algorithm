import java.util.*;
import java.io.*;

public class Solution {

	private static int[][] cheese;
	private static boolean[][] visit;
	private static int max;
	private static int N;

	// 델타 -> 상하 좌우
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			cheese = new int[N][N];

			max = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
				}

			}

			// 0~100일 진행
			for (int day = 0; day <= 100; day++) {

				// 매 날짜마다 치즈를 먹고나서 덩어리를 카운트
				// 이때 사용할 visit 배열을 초기화
				visit = new boolean[N][N];
				int cheeseCnt = 0;

				// 치즈 먹기 시작
				for (int i = 0; i < cheese.length; i++) {
					for (int j = 0; j < cheese.length; j++) {
						if (day == cheese[i][j]) {
							// 치즈 먹은 날은 0으로 처리
							cheese[i][j] = 0;
							visit[i][j] = true;
						}
					}

				} // 치즈를 먹는 처리

				// 치즈 덩어리를 카운트
				// 모든 위치에서 치즈덩어리 카운트 시작
				for (int i = 0; i < cheese.length; i++) {
					for (int j = 0; j < cheese.length; j++) {
						if (visit[i][j] || cheese[i][j] == 0) {
							continue;
						} // 방문을 했다면.,혹은 치즈가 덩어리가 아니면 dfs를 진행하지않는다
						dfs(i, j);

						// 치즈덩어리를 셀 수 있는 위치에서 연결 된 모든 치즈덩어리를 탐색했으므로
						// 치즈 덩어리 하나를 증가
						cheeseCnt++;
					}
				} // 치즈 카운트 반복문
				max = Math.max(max, cheeseCnt);

			} // 날짜 진행반복문
			System.out.println("#" + tc + " "+ max);
		}

	}

	// 스택, 재귀함수
	private static void dfs(int i, int j) {
		// 기저조건
		// 1. 델타 탐색을 할 것 이니 치즈 범위 내부인지를 체크
		// 2. 이미 방문했는가? -> 치즈를 먹은 구역, 치즈 덩어리로 이미 방문 된 구역
		// 3. 치즈덩어리 위치인가 -> true
		if (i < 0 || j < 0 || i >= N || j >= N || visit[i][j] || cheese[i][j] == 0) { // 이미 먹은 구역이거나 , 치즈덩어리로 카운트 된 경우, 범위를
																					// 벗어난 경우는 재귀종료
			return; // 더이상 진행하지않겠다
		}

		// 위 조건에 걸리지 않았을 경우 -> 치즈 덩어리 위에 있으며 범위를 벗어나지 않았음
		visit[i][j] = true; // 치즈와 연속된 덩어리를 체크

		// 델타 -> 상, 하, 좌, 우로 연결된 치즈인지 확인
		for (int k = 0; k < dr.length; k++) {
			// 다음 인덱스 계산 -> 상, 하, 좌, 우
			int nr = i + dr[k];
			int nc = j + dc[k];

			dfs(nr, nc);
		}
		// 재귀파트
	}
}
