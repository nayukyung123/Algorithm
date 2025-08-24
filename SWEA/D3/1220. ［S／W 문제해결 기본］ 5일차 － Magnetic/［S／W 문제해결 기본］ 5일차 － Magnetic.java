import java.util.*;
import java.io.*;


public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int count = 0;
			for (int c = 0; c < N; c++) {
				boolean seenOne = false; 
				for (int r = 0; r < N; r++) {
					int v = arr[r][c];
					if (v == 1) {
						seenOne = true; 
					} else if (v == 2 && seenOne) {
						count++; 
						seenOne = false; 
					}
				}
			}
			System.out.println("#" + tc + " " + count);

		}

	}
}
