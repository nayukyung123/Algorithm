import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine()); // 노선 갯수

			int[] stops = new int[5001];

			for (int i = 0; i < n; i++) {// 해당 노선은 A ~ B 이하인 정류장을 지나간다
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				for (int j = A; j <= B; j++) {
					stops[j]++;
				}
			}

			int p = Integer.parseInt(br.readLine());// 정류장 갯수

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			for (int i = 0; i < p; i++) {
				int C = Integer.parseInt(br.readLine()); // 정류장 번호 
				sb.append(stops[C]).append(" ");
			}
			
			System.out.println(sb);

		}
	}
}
