import java.io.*;
import java.util.*;

public class Solution {

    static int N, ans;
    static int[][] map;
    static int[] dr = { 1, 1, -1, -1 };
    static int[] dc = { 1, -1, -1, 1 };
    static boolean[] dessert;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = -1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dessert = new boolean[101];
                    dessert[map[i][j]] = true;     
                    dfs(i, j, i, j, 0, 1);        
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }

    private static void dfs(int r, int c, int startR, int startC, int dir, int count) {
        for (int d = dir; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

            if (nr == startR && nc == startC && d == 3 && count >= 4) {
                ans = Math.max(ans, count);
                return;
            }

            if (!dessert[map[nr][nc]]) {
                dessert[map[nr][nc]] = true;
                dfs(nr, nc, startR, startC, d, count + 1); 
                dessert[map[nr][nc]] = false;            
            }
        }
    }
}