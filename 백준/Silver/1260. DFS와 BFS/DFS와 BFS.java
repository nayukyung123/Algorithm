import java.io.*;
import java.util.*;

public class Main {
	static int N, M, V;
	static List<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);

		}

		for (int i = 0; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[N + 1];
		dfs(V);
		
		System.out.println();
		
		visited = new boolean[N + 1];
		bfs(V);

	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			System.out.print(cur + " ");
			
			for (int next : graph[cur]) {
				if(!visited[next]) {
					visited[next]=true;
					q.offer(next);
				}
			}
		}
	}

	private static void dfs(int node) {
		visited[node] = true;
		System.out.print(node + " ");
		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}

	}
}