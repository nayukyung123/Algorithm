import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//교착상태 ans 
//1 -> 2이 되면 ans++
//열을 시준으로 세로 탐색
//열을 고정하고 행을 위->아래로 스킨 후 1 만난후 2 만나면 ans++
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] table = new int[n][n];

			for (int i = 0; i < table.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < table.length; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = 0;// 교착상태

			for (int y = 0; y < table.length; y++) { // 열(가로) 고정
				boolean hasN = false;

				for (int x = 0; x < table.length; x++) {

					if (table[x][y] == 1)
						hasN = true;
					if (table[x][y] == 2 && hasN) {
						ans++;
						hasN = false;
					}

				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
