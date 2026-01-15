import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					result.add(bfs(i,j));
				}
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for (int count : result) {
			System.out.println(count);
		}
	}

	private static Integer bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		visited[x][y] = true;
		
		int count = 1;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = cx + dr[i];
				int nc = cy + dc[i];
				
				if( nr >= 0 && nc >= 0 && nr < n && nc < n && map[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc});
					count++;
				}
			}
		}
		
		return count;
	}
}