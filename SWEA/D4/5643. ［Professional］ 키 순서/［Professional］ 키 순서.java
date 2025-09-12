import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static List<List<Integer>> taller, shorter; // 키 큰 학생, 키 작은 학생 관계 저장
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            
            taller = new ArrayList<>();
            shorter = new ArrayList<>();
            
            for (int i = 0; i <= N; i++) {
                taller.add(new ArrayList<>());
                shorter.add(new ArrayList<>());
            }
            
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                // a < b
                taller.get(a).add(b);   // a보다 큰 학생 b
                shorter.get(b).add(a); // b보다 작은 학생 a
            }
            
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                int small = bfs(i, shorter); // 자신보다 작은 학생 수
                int big = bfs(i, taller);    // 자신보다 큰 학생 수
                if (small + big == N - 1) {
                    answer++;
                }
            }
            
            System.out.println("#" + tc + " " + answer);
        }
    }
    
    private static int bfs(int start, List<List<Integer>> graph) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}