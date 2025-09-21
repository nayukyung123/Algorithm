import java.io.*;
import java.util.*;

public class Solution {

    static int ans;
    static int[][] map = new int[16][16];
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();

            for (int i = 0; i < 16; i++) {
                String line = br.readLine();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            ans = 0;
            visited = new boolean[16][16];

            // 시작점(2)에서 DFS 시작
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    if (map[i][j] == 2) {
                        visited[i][j] = true;
                        dfs(i, j);
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }

    private static void dfs(int r, int c) {
        if (ans == 1) return; 

        if (map[r][c] == 3) { 
            ans = 1;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16 
                    && !visited[nr][nc] && map[nr][nc] != 1) {
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }
}