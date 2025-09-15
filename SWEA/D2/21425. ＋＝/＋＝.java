import java.io.*;
import java.util.*;

public class Solution {

	static int A, B, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int result = getOper(A, B, N);
			System.out.println(result);

		}

	}

	private static int getOper(int a2, int b2, int n2) {
		int cnt = 0;
		while (Math.max(a2, b2) <= n2) {
			if (a2 > b2) {
				b2 += a2;
			} else {
				a2 += b2;
			}
			cnt++;

		}
		return cnt;
	}
}

//작은 값에 큰값을 더해야  최소로 수행할 수 있다... 
