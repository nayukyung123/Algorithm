import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;

public class Solution {

	static int N;
	static int count;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];

			count = 0;
			nQueen(0);

			System.out.println("#" + tc + " " + count);

		}
	}

	private static void nQueen(int row) {
		if (row == N) {
			count++;
			return;
		}

		for (int col = 0; col < N; col++) {
			arr[row] = col;

			if (possible(row))
				nQueen(row + 1);
		}

	}

	private static boolean possible(int row) {
		for (int i = 0; i < row; i++) {
			if (arr[i] == arr[row]) {
				return false;
			}
			if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
				return false;
			}
		}
		return true;

	}

}
