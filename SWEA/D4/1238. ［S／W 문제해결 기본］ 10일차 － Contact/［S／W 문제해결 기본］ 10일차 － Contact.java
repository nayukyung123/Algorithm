import java.io.*;
import java.util.*;

public class Solution {
    static int N, start;
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) { // SWEA 1238은 테스트 케이스 10개 고정
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());     // 데이터 길이 (간선 개수 * 2)
            start = Integer.parseInt(st.nextToken()); // 시작점

            graph = new ArrayList<>();
            for (int i = 0; i <= 100; i++) { // 문제에서 정점 번호는 1~100
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) { // 간선 정보 N/2개
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph.get(from).add(to); // 단방향 그래프
            }

            int answer = bfs(start);
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[101];
        q.add(start);
        visited[start] = true;

        int result = 0;

        while (!q.isEmpty()) {
            int size = q.size(); // 현재 레벨(동시에 연락받는 사람 수)
            int maxNum = 0;      // 현재 레벨에서 가장 큰 번호

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                maxNum = Math.max(maxNum, cur);

                for (int next : graph.get(cur)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }

            result = maxNum; // 마지막 레벨에서 가장 큰 번호가 정답
        }

        return result;
    }
}