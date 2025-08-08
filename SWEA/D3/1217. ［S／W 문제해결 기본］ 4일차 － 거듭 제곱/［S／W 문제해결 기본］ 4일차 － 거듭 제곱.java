import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int caseNum = sc.nextInt(); // 케이스번호
			int base = sc.nextInt(); // 두개의 숫자 중 하나
			int exp = sc.nextInt(); // 두개의 숫자 중 하나

			System.out.println("#" + caseNum + " " + fact(base, exp));

		}

	}

	private static int fact(int base, int exp) {
		if (exp == 0)
			return 1;
		return base * fact(base, exp - 1);
	}
}
