import java.io.*;
import java.util.*;

public class Solution {

	static int[][] map = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			boolean isValid = true;
			
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 맵 입력받음
			
			
			// 가로
			for (int i = 0; i < 9 && isValid; i++) {
				Set<Integer> row = new HashSet<>();
				for (int j = 0; j < 9; j++) {
					int num = map[i][j];
					if (!row.add(num)) {
						isValid = false;
						break;
					}
				}
			}
			// 세로
			for (int j = 0; j < 9 && isValid; j++) {
				Set<Integer> col = new HashSet<>();
				for (int i = 0; i < 9; i++) {
					int num = map[i][j];
					if (!col.add(num)) {
						isValid = false;
						break;
					}
				}
			}
			// 3 x 3
			for (int startR = 0; startR < 9 && isValid; startR += 3) {
				for (int startC = 0; startC < 9 && isValid; startC += 3) {
					Set<Integer> block = new HashSet<>();
					for (int r = startR; r < startR + 3; r++) {
						for (int c = startC; c < startC + 3; c++) {
							int num = map[r][c];
							if (!block.add(num)) {
								isValid = false;
								break;
							}
						}
						if(!isValid) break;
					}
				}
			}
			System.out.println("#" + tc + " " + (isValid ? 1 : 0));
		}
	}
}
