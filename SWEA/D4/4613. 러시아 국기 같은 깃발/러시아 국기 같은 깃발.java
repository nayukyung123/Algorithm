import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 행과 열
			int m = Integer.parseInt(st.nextToken());


			char[][] map = new char[n][m];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = line.charAt(j);
				}
			}

			int min = Integer.MAX_VALUE;// 새로 칠해야 하는 칸의 최소값

			for (int i = 0; i < n - 2; i++) { // 여기까지 흰색임 
				for (int j = i + 1; j < n - 1; j++) {// 여기까지 파랑임 (나머지는 빨강임)
					int count = 0; // 색을 칠해야 한다면 카운트를 증가시킨다

					for (int r = 0; r <= i; r++) {
						for (int c = 0; c < m; c++) {
							if (map[r][c] != 'W')
								count++;
						}
					} // 흰색 칠하기

					for (int r = i + 1; r <= j; r++) {
						for (int c = 0; c < m; c++) {
							if (map[r][c] != 'B')
								count++;
						}
					} // 파란색 칠하기

					for (int r = j + 1; r < n; r++) {
						for (int c = 0; c < m; c++) {
							if (map[r][c] != 'R')
								count++;
						}
					} // 빨간색 칠하기
					
					min = Math.min(min, count);
				} 
				
			} 
			System.out.println("#" + tc + " " + min);

		}
	}
}