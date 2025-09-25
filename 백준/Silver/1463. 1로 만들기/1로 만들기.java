import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1]; // dp[i]= i 를 1로 만드는 최소 연산 횟수

		dp[0] = 0;
		dp[1] = 0;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1; // 1을 빼는 경우 항상 가능

			// 2로 나눠떨어질 때
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}

			// 3로 나눠떨어질 때
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}

		}
		System.out.println(dp[n]);

	}
}
