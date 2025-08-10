
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int t = 1; t <= T; t++) {
            int caseNum = sc.nextInt();
            int[][] arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            int d1 = 0, d2 = 0;

            for (int i = 0; i < 100; i++) {
                int row = 0, col = 0;
                for (int j = 0; j < 100; j++) {
                    row += arr[i][j]; // i행 합
                    col += arr[j][i]; // i열 합
                }
                d1 += arr[i][i];
                d2 += arr[i][99 - i];
                max = Math.max(max, Math.max(row, col));
            }

            max = Math.max(max, Math.max(d1, d2));

            System.out.println("#" + caseNum + " " + max);
        }
    }
}