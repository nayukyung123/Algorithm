import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] price = new int[N];

			for (int i = 0; i < N; i++) {
				price[i] = sc.nextInt();
			}

			long profit = 0L;
			int maxRight = 0;

			for (int i = N -1 ; i >= 0; i--) {
				if (price[i] > maxRight)
					maxRight = price[i];
				else
					profit += (maxRight - price[i]);

			}

			System.out.println("#" + tc + " " + profit);

		}

	}
}
