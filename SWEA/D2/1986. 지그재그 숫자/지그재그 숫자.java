import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 입력 받기
			int ans = 0;
			// 홀수는 더하고, 짝수는 빼기

			for (int i = 1; i <= N; i++) {
				if (i % 2 == 0) { // 짝수는 빼기
					ans -= i;
				} else {
					ans += i;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
