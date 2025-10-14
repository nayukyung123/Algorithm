import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2567_색종이
// 시뮬레이션
// 100 x 100 도화지 위에 색종이 부분을 1로 하고
// 1이 있는 칸 마다 상하좌우를 살펴 비어있는 곳의 개수를 둘레로 더한다
public class Main {

	static int x, y;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] paper = new int[101][101];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 색종이 개수

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			// 색종이부분을 1로 채우기
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					paper[j][k] = 1;
				}
			}
		}

		int cnt = 0; // 둘레
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				// 색종이라면
				if (paper[i][j] == 1) {
					// 주변 탐색
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						// 주변이 범위를 벗어난 경우 => 둘레임
						if (isOk(nr, nc)) {
							cnt++;
						}
						// 주변이 0인 경우 => 둘레임
						else if (paper[nr][nc] == 0) {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}

	// 범위를 벗어나면 true (= 둘레이면 true)
	private static boolean isOk(int nr, int nc) {
		if (nr >= 100 || nc >= 100 || nr < 0 || nc < 0) {
			return true;
		}
		return false;
	}
}
