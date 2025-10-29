import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 돌의 초기상태
			int m = Integer.parseInt(st.nextToken()); // 뒤집을 것들

			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); // 돌의 초기상태 채우기
			}

			for (int a = 0; a < m; a++) { // 뒤집을 번호(시작, 끝)
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());

				int start = i -1;
				
				int targetValue = arr[start];
				

				for (int k = 0; k < j; k++) {
					int currIndex = start + k;
					if(currIndex < n) {
						arr[currIndex] = targetValue;
					} else {
						break;
					}
				}

			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);

			for (int i = 0; i < n; i++) {
				sb.append(" ").append(arr[i]);
			}
			System.out.println(sb.toString());

		}
	}
}