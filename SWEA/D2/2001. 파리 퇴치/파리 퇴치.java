import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			
			int max = 0;
			
			for (int i = 0; i <= N - M ; i++) {
				for (int j = 0; j <= N - M; j++) {
					int sum = 0;
					
					for (int k = i; k < i + M; k++) {
						for (int l = j; l < j + M; l++) {
							sum += map[k][l];
						}
					}
					max = Math.max(max, sum);
				}
			} 
			System.out.println("#" + tc + " " + max);
		}
	}
}
