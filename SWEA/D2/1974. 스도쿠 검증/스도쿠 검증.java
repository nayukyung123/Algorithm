import java.util.*;

//d
// 스도쿠 퍼즐의 숫자들이 주어졌을 때,겹치는 숫자가 없을 경우-> 1 ,,   그렇지 않을 경우 0 을 출력한다
//d1 1 에서 9 까지의 숫자를 한번씩만 넣고, 3 x 3 크기의 작은 격자 또한, 1 에서 9 까지의 숫자가 겹치지 않아야 한다.
//d
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for (int tc = 1; tc <= T; tc++) {
			int[][] map = new int[9][9];
			boolean valid = true;

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					map[i][j] = sc.nextInt();
			} // 9*9 퍼즐

			for (int i = 0; i < 9; i++) {
				Set<Integer> set = new HashSet<>();
				for (int j = 0; j < 9; j++) {
					if (!set.add(map[i][j]))
						valid = false;

				}
			} // 행 검사

			for (int j = 0; j < 9; j++) {
				Set<Integer> set = new HashSet<>();
				for (int i = 0; i < 9; i++) {
					if (!set.add(map[i][j]))
						valid = false;

				}
			} // 열 검사

			for (int bi = 0; bi < 9; bi += 3) {
				for (int bj = 0; bj < 9; bj += 3) {
					Set<Integer> boxSet = new HashSet<>();
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							int num = map[bi + i][bj + j];
							if (!boxSet.add(num))
								valid = false;

						}
					}
				}

			}// 3*3 검사 
			
			int result = valid ? 1 : 0;
			System.out.println("#" + tc + " " + result);
		}
	}
}