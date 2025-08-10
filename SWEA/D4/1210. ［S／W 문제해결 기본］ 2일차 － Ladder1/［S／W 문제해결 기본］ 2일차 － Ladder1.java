import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 100;

        for (int t = 1; t <= 10; t++) {
            int tc = sc.nextInt();           // 입력에 있는 케이스 번호 사용
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    arr[i][j] = sc.nextInt();

            int row = N - 1, col = 0;
            for (int j = 0; j < N; j++)      // 바닥에서 2 찾기
                if (arr[row][j] == 2) { col = j; break; }

            while (row > 0) {
                // 왼쪽 우선으로 수평 이동
                if (col > 0 && arr[row][col - 1] == 1) {
                    while (col > 0 && arr[row][col - 1] == 1) col--;
                }
                // 오른쪽 수평 이동
                else if (col < N - 1 && arr[row][col + 1] == 1) {
                    while (col < N - 1 && arr[row][col + 1] == 1) col++;
                }
                // 위로 한 칸
                row--;
            }

            System.out.println("#" + tc + " " + col);
        }
    }
}