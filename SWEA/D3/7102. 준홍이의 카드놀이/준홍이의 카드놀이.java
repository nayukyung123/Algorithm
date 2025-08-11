import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// 두개의 주사위를 돌렸을 때의 합 중 등장할 확률이 높은것...
		// 합 sum 가 나올 경우의 수
		// 최빈값
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 첫 번째 카드 세트
			int M = sc.nextInt(); // 두 번째 카드 세트

			int lo = Math.min(N, M) + 1;// 최빈 합의 시작
			int hi = Math.max(N, M) + 1;// 최빈 합의 끝

			System.out.print("#" + tc + " ");
			for (int s = lo; s <= hi; s++) {
				System.out.print(s + " ");
			}
			System.out.println();
		}

	}

}
