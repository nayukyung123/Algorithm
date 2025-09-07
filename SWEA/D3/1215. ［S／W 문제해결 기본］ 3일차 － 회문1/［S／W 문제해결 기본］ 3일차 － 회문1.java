import java.util.*;

public class Solution {
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();
            map = new char[8][8];

            for (int i = 0; i < 8; i++) {
                String line = sc.next(); // 8글자 붙어서 들어옴
                for (int j = 0; j < 8; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            int count = 0;

            // 가로 검사
            for (int row = 0; row < 8; row++) {
                for (int start = 0; start <= 8 - N; start++) {
                    if (isPalindromeRow(row, start, N)) count++;
                }
            }

            // 세로 검사
            for (int col = 0; col < 8; col++) {
                for (int start = 0; start <= 8 - N; start++) {
                    if (isPalindromeCol(col, start, N)) count++;
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }

    private static boolean isPalindromeCol(int col, int start, int n) {
        for (int k = 0; k < n / 2; k++) {
            if (map[start + k][col] != map[start + n - 1 - k][col]) return false;
        }
        return true;
    }

    private static boolean isPalindromeRow(int row, int start, int n) {
        for (int k = 0; k < n / 2; k++) {
            if (map[row][start + k] != map[row][start + n - 1 - k]) return false;
        }
        return true;
    }
}