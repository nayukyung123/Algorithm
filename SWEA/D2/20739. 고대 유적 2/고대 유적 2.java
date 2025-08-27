import java.util.*;
import java.io.*;

// 모든 행을 검사해서 가장 긴 가로 구조물의 길이를 찾기 
// 모든 열을 검사해서 가장 긴 세로 구조물의 길이를 찾기 
// 둘 중 더 긴 값을 출력하기 

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 사진 데이터의 개수

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // N행
			int M = sc.nextInt(); // M열
			int[][] arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int maxLen = 0; // 가장 긴 구조물 길이

			// 가로탐색 
			for (int i = 0; i < N; i++) {
				int currentlen = 0; // 현재 행에서 연속된 1의 길이를 셈 
				for (int j = 0; j < M; j++) {
					if(arr[i][j] == 1) {
						currentlen++;
					}else {
						if(currentlen > 1 )  //@@ 길이가 1인 것은 구조물로 치지 않는다 @@
						maxLen = Math.max(maxLen, currentlen);//0을 만나면 지금까지 센 길이를 maxLen과 비교 후 currentLen 초기
						currentlen = 0;
								
					}
				}
				if(currentlen > 1 ) 
				maxLen = Math.max(maxLen, currentlen);// 행이 끝났을 때, 1로 끝나는 경우를 대비해 한번더 비교 
			}
			// 새로탐색 
			for (int j = 0; j < M; j++) {
				int currentlen = 0;
				for (int i = 0; i < N; i++) {
					if(arr[i][j] == 1) {
						currentlen++;
					}else {
						if(currentlen > 1 ) //@@ 길이가 1인 것은 구조물로 치지 않는다 @@
						maxLen = Math.max(maxLen, currentlen);
						currentlen= 0;
					}
				}
				if(currentlen > 1 ) 
				maxLen = Math.max(maxLen, currentlen);
			}

			System.out.println("#" + tc + " " + maxLen);

		}

	}
}
