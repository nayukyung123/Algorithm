import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (a, b) -> {
			// x좌표가 같다면 y 를 오름
			if (a[0] == b[0]) {
				return Integer.compare(a[1], b[1]);
			}
			// 같지 않다면 그냥 오름
			return Integer.compare(a[0], b[0]);
		});
		
		StringBuilder sb = new StringBuilder();
		for (int[] pair : arr) {
			sb.append(pair[0]).append(" ").append(pair[1]).append("\n");
		}
		System.out.println(sb.toString());

	}
}
