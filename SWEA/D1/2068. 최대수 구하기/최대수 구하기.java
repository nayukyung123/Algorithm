
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int[] arr = new int[10];
			int max = 0; // 최대값

			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				max = Math.max(max, arr[i]);
			}
			System.out.println("#" + tc + " " + max);
		}

	}
}
