import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[5001];

			for (int i = 0; i < N; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();

				for (int j = A; j <= B; j++) {
					arr[j] += 1;
				}
			}
			int P = sc.nextInt();

			System.out.print("#" + tc + " ");
			for (int i = 0; i < P; i++) {
				int station = sc.nextInt();
				System.out.print(arr[station] + " ");
			}

			System.out.println();
		}

	}
}
