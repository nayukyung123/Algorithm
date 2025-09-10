import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int[] arr = new int[10];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();

			} // 10개 입력받기

			int sum = 0;
			
			// 평균 계산하기
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i]; // 모든 걸 더함
			}
			
			long avg = 0;
			avg = Math.round(sum/10.0);

			System.out.println("#" + tc + " " + avg);

		}

	}
}
