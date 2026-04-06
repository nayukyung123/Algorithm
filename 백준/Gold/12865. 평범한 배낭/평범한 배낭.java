import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] items = new int[N + 1][2]; // 입력값 받는 창고
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N + 1][K + 1]; // 계산판

		for (int i = 1; i <= N; i++) { // 물건 꺼내기
			int weight = items[i][0];
			int value = items[i][1];

			for (int j = 1; j <= K; j++) { // 최대 무게에 다가가기

				if (weight > j) {
					// 현재 무게가 최대 무게보다 높다?
					// 이전 물건 까지의 물건 가치 가져온다.
					dp[i][j] = dp[i - 1][j];

				} else {
					// 현재 무게가 최대 무게보다 낮다?
					// 이전과 넣었을 때 비교해서
					// 큰놈을 가져오자르자
					dp[i][j] = Math.max(dp[i - 1][j], value + dp[i - 1][j - weight]);
				}
			}

		}
		System.out.println(dp[N][K]);
	}
}
