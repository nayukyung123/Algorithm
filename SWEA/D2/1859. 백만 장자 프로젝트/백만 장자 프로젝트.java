import java.util.*;
import java.io.*;

public class Solution {

	static int day, maxPrice;
	static long profit; 
	static int[] priceArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			priceArr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				priceArr[i] = Integer.parseInt(st.nextToken());
			}

			maxPrice = 0; 
			profit = 0;

			for (int i = N - 1; i >= 0; i--) {
				if (priceArr[i] < maxPrice) {
					profit += maxPrice - priceArr[i];
				} else {
					maxPrice = priceArr[i];
				}
			}
			System.out.println("#" + tc + " " + profit);
		}

	}
}
