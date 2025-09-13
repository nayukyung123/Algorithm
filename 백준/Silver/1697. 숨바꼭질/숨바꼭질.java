import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];

		System.out.println(bfs(N, K));
	}

	private static int bfs(int start, int target) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start,0});
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int pos = cur[0];
			int time = cur[1];
			
			if(pos == target) return time;
			
			int[] moves = {pos-1, pos +1, pos * 2};
			for (int i : moves) {
				if (i >=0 && i <= 100000&& !visited[i]) {
					visited[i] = true;
					q.offer(new int[] {i,time+1});
					
				}
			}
			
			
		}
		return -1;
		
		
	}
}
