import java.io.*;
import java.util.*;

public class Solution {

	static int N, K, TOP, maxLen;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			TOP = 0;
			visited = new boolean[N][N];
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					TOP = Math.max(TOP, map[i][j]);
				}
			}

			maxLen = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == TOP) {
						dfs(i, j, 1, false);
					}
				}
			}
			System.out.println("#" + tc + " " + maxLen);
		}
	}

	private static void dfs(int i, int j, int len, boolean usedK) {
		visited[i][j] = true;

		maxLen = Math.max(maxLen, len);

		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
				if(map[nr][nc] < map[i][j]) { 
					dfs(nr,nc,len+1,usedK);
				}else {  
					if(!usedK && map[nr][nc]-K < map[i][j]) {
						int original = map[nr][nc];
						map[nr][nc] = map[i][j]-1;
						dfs(nr,nc,len+1,true);
						map[nr][nc] =original;
						
					}
				}
			}

		}
		visited[i][j] = false;

	}
}