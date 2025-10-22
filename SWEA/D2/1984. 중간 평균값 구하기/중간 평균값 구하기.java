import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
중간 평균 값 구하기

<입력받음>
테케 
10개의 수 

<구현>
1. 최대수max 와 최소수min 구함
	max와 min을 제외한 나머지를 더한다sum
	
2. 평균값ans구함 
*/
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// <입력받음>
			int[] arr = new int[10];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// <구현>
			// 최대 / 최소
			int max = 0;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i]);
				sum += arr[i];
			}
			
			// 최대 / 최소 제외하고 합
			sum -= max;
			sum -= min;
			
			// 평균 값
			int avg = (int) Math.round(sum / 8.0);
			
			System.out.println("#" + tc + " " + avg);
			
		}
	}
}