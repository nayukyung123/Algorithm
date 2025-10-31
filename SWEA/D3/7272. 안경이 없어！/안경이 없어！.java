import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();

			int[] arr = new int[26];

			arr['A' - 'A'] = 1;
			arr['D' - 'A'] = 1;
			arr['O' - 'A'] = 1;
			arr['P' - 'A'] = 1;
			arr['Q' - 'A'] = 1;
			arr['R' - 'A'] = 1;

			arr['B' - 'A'] = 2;

			String result = "SAME";

			if (str1.length() != str2.length()) {
				result = "DIFF";
			} else {

				for (int i = 0; i < str1.length(); i++) {
					int hole1 = arr[str1.charAt(i) - 'A'];
					int hole2 = arr[str2.charAt(i) - 'A'];

					if (hole1 != hole2) {
						result = "DIFF";
						break;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}
}