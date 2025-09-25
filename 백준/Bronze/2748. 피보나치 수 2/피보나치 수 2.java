import java.io.*;
import java.util.*;

public class Main {
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		dp = new long[n + 1];

		dp[0] = 0;
		if (n > 0)
			dp[1] = 1;

		fibo(n);
		System.out.println(dp[n]);

	}

	private static void fibo(int n) {
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
	}
}
