import java.io.*;
import java.util.*;

public class Solution {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 원소 개수
            int m = Integer.parseInt(st.nextToken()); // 연산 개수

            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i; // 자기 자신을 대표로 초기화
            }

            sb.append("#").append(tc).append(" ");

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (cmd == 0) { // union
                    union(a, b);
                } else { // find
                    if (find(a) == find(b)) sb.append(1);
                    else sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            parent[pb] = pa; // 같은 집합으로 합침
        }
    }
}