import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] carrots = new int[N];

			for (int i = 0; i < N; i++) {
				carrots[i] = sc.nextInt();
			}

			if (N == 1) {
				System.out.println("#" + tc + " " + 1);
				continue;
			}

			int max_count = 1; // 최대 길이
			int current_count = 1; // 현재 연속 길이

			for (int i = 1; i < N; i++) {
				if (carrots[i] > carrots[i - 1]) {
					current_count++;
				} else {
					current_count = 1;
				}

				if (current_count > max_count) {
					max_count = current_count;
				}
			}
			System.out.println("#" + tc + " " + max_count);
		}
	}
}