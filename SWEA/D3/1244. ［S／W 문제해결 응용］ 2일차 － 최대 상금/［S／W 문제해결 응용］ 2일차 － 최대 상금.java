import java.util.*;
import java.io.*;

//.	퀴즈 대회 보너스 상금 최대화
//* - 정확히 K번 자리 교환 후 만들 수 있는 최대 값

public class Solution {
	static int max;
	static Set<String> visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String numStr = sc.next();
			int N = sc.nextInt();

			max = 0;
			visited = new HashSet<>();

			char[] arr = numStr.toCharArray();

			dfs(arr, N);

			System.out.println("#" + tc + " " + max);
		}

	}

	private static void dfs(char[] arr, int n) {
	
		if (n == 0) {
			int val = Integer.parseInt(new String(arr)); 
			if (val > max)
				max = val;
			return;
		}
	
		String key = new String(arr) + "|" + n;
		if (!visited.add(key))
			return;

		int len = arr.length;

		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				swap(arr, i, j);
				dfs(arr, n - 1);
				swap(arr, i, j);
			}

		}

	}

	private static void swap(char[] arr, int i, int j) {
		char t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;

	}
}
