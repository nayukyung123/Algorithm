import java.util.Scanner;

public class Solution {
	// 각 노드의 정보 저장용 배열
	static boolean[] isOp; // 해당 노드가 연산자인지
	static char[] op; // 연산자저장
	static int[] L, R; // 왼쪽, 오른쪽 자식 노드번호
	static double[] val; // 숫자값저장

	// 트리를 재귀적으로 계산하는 메서드
	static double eval(int idx) {
		if (!isOp[idx])
			return val[idx]; // 연산자가 아니라면 반환
		double a = eval(L[idx]); // 왼쪽 서브트리계산결과
		double b = eval(R[idx]); // 오른쪽 서비트리 계산결과

		return op[idx] == '+' ? a + b : op[idx] == '-' ? a - b : op[idx] == '*' ? a * b : a / b;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();

			// 배열 크기 설정 (노드 번호가 1부터 시작하므로 N+1)
			isOp = new boolean[N + 1];
			op = new char[N + 1];
			L = new int[N + 1];
			R = new int[N + 1];
			val = new double[N + 1];

			// N개의 노드 정보 입력 처리
			for (int i = 0; i < N; i++) {
				int idx = sc.nextInt();// 현재 노드 번호
				String s = sc.next();// 숫자 또는 연산자

				if ("+-*/".contains(s)) {
					isOp[idx] = true;
					op[idx] = s.charAt(0);
					L[idx] = sc.nextInt();
					R[idx] = sc.nextInt();
				} else {
					val[idx] = Double.parseDouble(s);
				}
			}
			System.out.println("#" + tc + " " + (int) eval(1));

		}
	}
}
