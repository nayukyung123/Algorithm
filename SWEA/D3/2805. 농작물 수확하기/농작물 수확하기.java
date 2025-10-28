import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 농장크기

			// 농작물의 가치
			int[][] form = new int[n][n];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {
					form[i][j] = line.charAt(j) - '0';
				}
			}
			
			int profit = 0;
			int mid = n / 2;
			for (int r = 0; r < n; r++) {
				int diff = Math.abs(mid-r);
				for (int c = diff; c < n - diff; c++) {
					profit += form[r][c];
				}
			}
			
			System.out.println("#" + tc + " " + profit);

		}
	}
}