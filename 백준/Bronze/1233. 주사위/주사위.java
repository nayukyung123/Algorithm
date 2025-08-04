import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// S1, S2, S3 주사위들
		int S1 = sc.nextInt();
		int S2 = sc.nextInt();
		int S3 = sc.nextInt();

		// 나올 수 있는 최대의 합
		int maxSum = S1 + S2 + S3;

		// 각 합의 빈도 확인을 위한 배열
		int[] freq = new int[maxSum + 1];

		for (int i = 1; i <= S1; i++) {
			for (int j = 1; j <= S2; j++) {
				for (int k = 1; k <= S3; k++) {
					int sum = i + j + k; // 현재 주사위 3개의 합
					freq[sum]++; // 해당 합의빈
				}

			}

		}
		// 가장 많이 나온 합과 빈도
		int maxCount = 0;
		int freqNo1 = 0;

		// 모든 가능한 합을 순회하며 가장 많이 나온 합 찾기
		for (int sum = 3; sum <= maxSum; sum++) {
			if (freq[sum] > maxCount) {
				maxCount = freq[sum]; // 더 많은 빈도
				freqNo1 = sum; // 해당 합을 정답후보로...
			}

		}

		System.out.println(freqNo1);

	}
}
