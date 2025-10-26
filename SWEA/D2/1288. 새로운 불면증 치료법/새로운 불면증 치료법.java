import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[] arr = new int[9];
			for (int i = 0; i < 9; i++) {
				arr[i] = N * (i + 1);
			} // N * ( 1 ~ 9 )

			boolean[] seen = new boolean[10];// 0 ~ 9 중복 체크 
			int cnt = 0;// 곱한개수 ( 출력 ) 
			int cntseen = 0;// 0 ~ 9 중 본 숫자의 개수 (10개)

			while (cntseen < 10) {
				cnt++;
				int num = N * cnt;
				String str = String.valueOf(num); // 10 -> "10"
				for (char c : str.toCharArray()) { // "10" -> "1", "0"
					int digit = c - '0'; // "10" -> 10
					if (!seen[digit]) {
						seen[digit] = true;
						cntseen++;
					}
				}

			}

			System.out.println("#" + tc + " " + N * cnt);
		}
	}

}
