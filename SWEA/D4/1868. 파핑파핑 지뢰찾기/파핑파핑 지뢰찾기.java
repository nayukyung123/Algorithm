import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static char[][] map;
    static int[][] cnt;        // 각 칸 주변 지뢰 개수
    static boolean[][] visited;
    static int[] dr = {-1,-1,-1,0,0,1,1,1};
    static int[] dc = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            cnt = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            // 1. 각 칸 주변 지뢰 개수 계산
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == '*') {
                        cnt[r][c] = -1; // 지뢰 표시
                        continue;
                    }
                    int bombs = 0;
                    for (int d = 0; d < 8; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == '*') {
                            bombs++;
                        }
                    }
                    cnt[r][c] = bombs;
                }
            }

            int clicks = 0;

            // 2. 주변 지뢰 개수가 0인 칸부터 BFS
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (cnt[r][c] == 0 && !visited[r][c]) {
                        bfs(r, c);
                        clicks++;
                    }
                }
            }

            // 3. 남은 빈 칸(`.`) 처리
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (cnt[r][c] >= 0 && !visited[r][c]) {
                        clicks++;
                    }
                }
            }

            System.out.println("#" + tc + " " + clicks);
        }
    }

    // BFS로 연쇄 오픈
    private static void bfs(int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            // 숫자가 0일 때만 주변을 확장
            if (cnt[r][c] == 0) {
                for (int d = 0; d < 8; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && cnt[nr][nc] >= 0) {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}