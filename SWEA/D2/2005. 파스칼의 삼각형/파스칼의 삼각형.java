import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// <입력받음>
			int n = Integer.parseInt(br.readLine());
			
			// <구현>
			int[] arr = new int[n];
			
			//출력
			System.out.println("#" + tc);
			arr[0] =1; // 첫 행은 항상 1
			System.out.println(1); // 첫 줄 출력 1 고정 
			
			// 전 줄의 왼/오 구하자
			for (int i = 1; i < arr.length; i++) { // 행을 움직이면서 
				for (int j = i; j > 0; j--) {	   // 그 행의 각 칸(col)을 계산 -> 역방향으로 섞어야 이전 줄 값 그대로 사용
					arr[j] = arr[j] + arr[j-1];	   // 위 행의 왼/오를 더함 
				}
				
				//현재 행 출력 
				for (int j = 0; j <= i; j++) {
					System.out.print(arr[j] + " ");
				}
				System.out.println(); // 줄바꿈
			}
		}
	}
}