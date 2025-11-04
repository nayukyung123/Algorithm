import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] dr = { 0, 1, 1, -1 };
	static int[] dc = { 1, 0, 1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int k = 0; k < m; k++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken()) - 1; // 시작 번호
				int j = Integer.parseInt(st.nextToken()); // 이동 갯수

				int copy = arr[i];// 저장해놓기

				for (int p = 0; p < j; p++) { // 시작번호부터 이동갯수 까지
					int curIdx = i + p;
					if (curIdx < n) { // 범위제한 
						arr[curIdx] = copy;
					} else
						break;
				}

			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			System.out.println(sb.toString());

		}
	}
}
