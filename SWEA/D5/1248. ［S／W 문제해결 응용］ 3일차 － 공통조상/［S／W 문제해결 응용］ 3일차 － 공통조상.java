import java.io.*;
import java.util.*;

public class Solution {
    static int V, E;
    static int[] parent, left, right;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            parent = new int[V + 1];
            left   = new int[V + 1];
            right  = new int[V + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (left[p] == 0) left[p] = c;
                else             right[p] = c;
                parent[c] = p;
            }

            int lca = lcaByVisited(a, b);
            int size = subtreeSize(lca);
            sb.append('#').append(tc).append(' ').append(lca).append(' ').append(size).append('\n');
        }
        System.out.print(sb.toString());
    }

    // (1) LCA: a의 조상들을 표시한 뒤 b를 위로 올리며 처음 만나는 노드 반환
    static int lcaByVisited(int a, int b) {
        boolean[] seen = new boolean[V + 1];
        for (int x = a; x != 0; x = parent[x]) seen[x] = true;
        for (int y = b; y != 0; y = parent[y]) if (seen[y]) return y;
        return 1; // 루트 1 보장
    }

    // (2) 서브트리 크기: LCA부터 스택으로 순회(비재귀)
    static int subtreeSize(int root) {
        int cnt = 0;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(root);
        while (!st.isEmpty()) {
            int u = st.pop();
            if (u == 0) continue;
            cnt++;
            if (left[u]  != 0) st.push(left[u]);
            if (right[u] != 0) st.push(right[u]);
        }
        return cnt;
    }
}