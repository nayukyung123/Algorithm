import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 가
			int m = Integer.parseInt(st.nextToken()); // 단어의 길이

			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = 0;// 단어가 만들어 지는 경우 수 카운트

			// 전체 배열을 돈다
			// 가로
			for (int i = 0; i < n; i++) {
				int cnt = 0;
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
						cnt++;
					} else { // 벽 만났을 때 
						if (cnt == m) {
							ans++;
						}
						cnt = 0;
					}
				}
				if (cnt == m) {
					ans++;
				}
			}

			// 세로 
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int i = 0; i < n; i++) {
					if (map[i][j] == 1) {
						cnt++;
					} else {
						if (cnt == m) {
							ans++;
						}
						cnt = 0;
					}
				}
				if (cnt == m) {
					ans++;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}