
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
			// 홀수입력받기
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] % 2 == 1) {
					sum += arr[i];
				}

			}

			System.out.println("#" + tc + " " + sum);

		}

	}
}
