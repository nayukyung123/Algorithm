import java.io.*;
import java.util.*;

public class Solution {
    // dx, dy와 함께 N, board도 static 변수로 선언하여 모든 메서드에서 접근 가능하게 함
    static int N;
    static char[][] board;
    static int[] dx = {1, 0, 1, 1}; // 하, 우, 우하, 좌하
    static int[] dy = {0, 1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int tc = 1; tc <= T; tc++) { // 1부터 T까지 T번 반복
            N = sc.nextInt();
            board = new char[N][N];
            sc.nextLine(); // nextInt() 후 줄바꿈 문자 제거

            // 올바른 입력 처리
            for (int i = 0; i < N; i++) {
                board[i] = sc.nextLine().toCharArray();
            }

            String result = "NO";
            boolean found = false; // 한번이라도 오목을 완성시키면 즉시 탐색 종료
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // char 배열이므로 == 로 비교 가능
                    if (board[i][j] == 'o') {
                        // 4가지 방향에 대해 오목 여부 확인
                        for (int d = 0; d < 4; d++) {
                            if (isOmok(i, j, d)) {
                                result = "YES";
                                found = true;
								break;
                            }
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
        }
        sc.close();
    }

    // static 변수를 사용하므로 board, N을 파라미터로 받을 필요 없음
    private static boolean isOmok(int x, int y, int d) {
        for (int k = 0; k < 5; k++) {
            int nx = x + k * dx[d];
            int ny = y + k * dy[d];
            
            // 판을 벗어나는지 확인
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                return false;
            }
            // 다른 돌이 있는지 확인
            if (board[nx][ny] != 'o') {
                return false;
            }
        }
        // 5번의 확인을 모두 통과했다면 오목
        return true;
    }
}