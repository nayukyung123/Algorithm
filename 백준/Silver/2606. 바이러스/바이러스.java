import java.io.*;
import java.util.*;

public class Main {

	static int N, M; // 정점, 간선
	static int a, b;
	static boolean[] visited;
	static List<Integer>[] graph;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		visited = new boolean[N+1];

		dfs(1);

		System.out.println(count - 1);

	}

	private static void dfs(int node) {
		visited[node] = true;
		count++;

		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
}
