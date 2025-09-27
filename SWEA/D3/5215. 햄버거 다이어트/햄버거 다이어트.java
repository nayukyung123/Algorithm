import java.io.*;
import java.util.*;

public class Solution {

	static int N, L, TA, K;// 재료의 수, 제한 칼로리, 맛점수, 칼로리
	static int max; // 최고의 맛 점수
	static int[] taste;
	static int[] cal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			taste = new int[N];
			cal = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				TA = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());

				taste[i] = TA;
				cal[i] = K;
			}

			max = 0;
			dfs(0, 0, 0);// 현재 어디까지 선택했는지, 점수합, 칼로리합
			System.out.println("#" + tc + " " + max); 

		}

	}

	private static void dfs(int idx, int sumTaste, int sumCal) {
		// 제한칼로리 N에 근접하면 리턴한다.....
		if (sumCal > L) {
			return;
		}

		// 맛 배열 중에 최고의 점수를 내는 조합
		if(idx == N) {
			max = Math.max(max, sumTaste);
			return;
		}
		
		dfs(idx+1, sumTaste+taste[idx], sumCal+ cal[idx]);
		
		dfs(idx+1, sumTaste,sumCal);

	}
}
