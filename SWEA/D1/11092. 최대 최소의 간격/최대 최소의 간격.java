import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i]= Integer.parseInt(st.nextToken());
			}
			
			int min = arr[0];
			int max = arr[0];
			int maxIdx = 1;
			int minIdx = 1;
			
			for (int i = 1; i < arr.length; i++) {
				if(arr[i] >= max) {
					max = arr[i];
					maxIdx = i+1;
				}
				
				if(arr[i] < min) {
					min = arr[i];
					minIdx = i+1;
				}
				
			}
			
			System.out.println("#" + tc + " " + (Math.abs(maxIdx-minIdx))); 
			
		}
	}
}