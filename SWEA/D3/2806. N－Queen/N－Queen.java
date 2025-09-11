
import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;

public class Solution {
	static int N;
	static int count = 0;
	static boolean[] usedRow; 
	static boolean[] usedDiag1;
	static boolean[] usedDiag2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			usedRow = new boolean[N];
			usedDiag1 = new boolean[2 * N];
			usedDiag2 = new boolean[2 * N];

			count = 0;
			palceQueen(0);
			System.out.println("#" + tc + " " + count);
		}

	}

	
	private static void palceQueen(int col) {
		if (col == N) {
			count++;
			return;
		}

		for (int row = 0; row < N; row++) { 
			if (usedRow[row] || usedDiag1[row + col] || usedDiag2[col - row + N - 1]) 
				continue;

			usedRow[row] = true;
			usedDiag1[row + col] = true;
			usedDiag2[col - row + N - 1] = true;

			palceQueen(col + 1); 

			usedRow[row] = false;
			usedDiag1[row + col] = false;
			usedDiag2[col - row + N - 1] = false;
		}
	}

}
