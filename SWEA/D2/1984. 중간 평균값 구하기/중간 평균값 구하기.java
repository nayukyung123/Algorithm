import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[10];
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max = 0;
			int min = Integer.MAX_VALUE;
			int sum = 0;

			for (int i = 0; i < arr.length; i++) {
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i]);
				sum += arr[i];
			} 

			sum -= max;
			sum -= min;

			int avg = (int) Math.round(sum / 8.0);

			System.out.println("#" + tc + " " + avg);
		}
	}
}
