import java.io.*;
import java.util.*;

public class Main {

	static List<Integer>[] graph;
	static int N, M, ans;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);

		}
		
		visited = new boolean[N+1];
		
		dfs(1); // 1번 컴퓨터를 통해 웜바이러스가 걸리는 컴퓨터의 수 출력
		System.out.println(ans-1);
	}

	private static void dfs(int node) {
		visited[node] = true;
		ans++;

		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}

	}
}