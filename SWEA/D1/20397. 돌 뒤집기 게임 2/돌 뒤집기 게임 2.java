import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[] arr = new int[n];
			for (int i = 0; i < n; i++) { // 돌의 초기 배열 상태
				arr[i] = sc.nextInt();
			}

			// 뒤집기 할 번호
			for (int k = 0; k < m; k++) {
				int i_center_pos = sc.nextInt(); 
				int j_pairs = sc.nextInt(); 

				int center = i_center_pos - 1;

				for (int p = 1; p <= j_pairs; p++) {

					// 마주보는 돌의 인덱스 계산
					int left = center - p;
					int right = center + p;

					if (left < 0 || right >= n) {
						break;
					}

					if (arr[left] == arr[right]) {
						// 둘 다 뒤집기
						arr[left] = 1 - arr[left];
						arr[right] = 1 - arr[right];
					}
				}
			}

			// 1. (StringBuilder 삭제) 테스트 케이스 번호 먼저 출력 (줄바꿈 없이)
			System.out.print("#" + tc); 

			// 2. (StringBuilder 삭제) 배열을 순회하며 공백 + 값 출력
			for (int next : arr) {
				System.out.print(" " + next);
			}
			
			// 3. (StringBuilder 삭제) 모든 출력이 끝나면 줄바꿈
			System.out.println(); 
		}
		
		sc.close();
	}
}