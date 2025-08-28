import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = 0; // 최댓값 
			int min =11; // 최솟값 
			int maxidx = 0; // 최댓값 위치 
			int minidx = 0; // 최솟값 위치 
			
			for (int i = 0; i < N; i++) {
				if (max <= arr[i]) {
					max = arr[i];
					maxidx = i + 1;
				}
				
				if (min > arr[i]) {
					min = arr[i];
					minidx = i+1;
				}
			}
			int result = Math.abs(maxidx - minidx);
			
			System.out.println("#" + tc + " " +result);

		}
	}
}