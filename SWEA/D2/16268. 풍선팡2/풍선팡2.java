import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 가로 
			int m = Integer.parseInt(st.nextToken()); // 세로 

			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = Integer.MIN_VALUE; // 꽃가루의최대값 
			
			
			for (int r = 0; r < n; r++) { // 전체를 돈다 
				for (int c = 0; c < m; c++) {
					int sum = arr[r][c]; // 가운데  
					
					for (int d = 0; d < 4; d++) { // 상하좌우  
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						
						if(nr >=0 && nr < n && nc >=0 && nc <m) { // 범위제한 
							sum += arr[nr][nc];
						}
					}
					max = Math.max(sum, max);
				}
			}
			System.out.println("#" + tc + " " + max); 
		}
	}
}
