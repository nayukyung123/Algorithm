import java.io.*;
import java.util.*;

public class Solution {
	private static int N, L; // 재료의 수, 제한 칼로리
	private static int[] score; // 맛 점수
	private static int[] cal; // 칼로리
	private static int max; // 최대 점수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			score = new int[N];
			cal = new int[N];
			max = 0;
			
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}

			subset(0, 0, 0); // idx, 총점, 총 칼로리
			System.out.println("#" + tc + " " + max);

		}
	}

	static void subset(int idx, int sumScore, int sumCal) {
		// 기저 조건
		if (sumCal > L) // 칼로리 초과 -> 가지치기
			return;
		if (idx == N) { // 모든 재료 고려 끝
			max = Math.max(max, sumScore);
			return;

		}
		// 현재 재료 선택
		subset(idx + 1, sumScore + score[idx], sumCal + cal[idx]);
		// 현재 재료 선택 안 함
		subset(idx + 1, sumScore, sumCal);
	}
}