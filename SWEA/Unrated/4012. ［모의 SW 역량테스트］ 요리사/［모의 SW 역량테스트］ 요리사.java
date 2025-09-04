import java.io.*;
import java.util.*;

public class Solution {
	static int N; // 식재료 개수
	static int[][] S; // 시너지 저장 배열
	static boolean[] selected; // 각 재료가 팀A에 속하는지 여부 표시
	static int min; // 두 팀 시너지 차이의 최소값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			S = new int[N][N];
			selected = new boolean[N]; // 초기엔 전부 false (팀B)
			min = Integer.MAX_VALUE;

			// 시너지 값 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					S[i][j] = sc.nextInt();
				}
			}

			// 팀 나누기
			combination(0, 0);

			System.out.println("#" + tc + " " + min);

		}
	}

	// N개 재료를 두 팀으로 나눈다
	private static void combination(int idx, int count) {
		if (count == N / 2) {
			calc(); // 시너지 계산
			return;
		}
		if (idx == N)
			return;

		// 팀 A
		selected[idx] = true;
		combination(idx + 1, count + 1);

		// 팀 B
		selected[idx] = false;
		combination(idx + 1, count);
	}

	// 시너지 계산
	private static void calc() {
		int A = 0;
		int B = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (selected[i] && selected[j]) { // 팀 A
					A += S[i][j] + S[j][i];
				}else if (!selected[i] && !selected[j]) { //팀 B
					B += S[i][j] + S[j][i];
				}
			}
			
		}
		
		 // 두 팀의 시너지 차이 최소값 갱신 abs:절대값
		min = Math.min(min, Math.abs(A - B));

	}

}