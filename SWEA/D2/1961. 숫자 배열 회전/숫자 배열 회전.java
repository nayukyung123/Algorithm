import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

/*
[문제 요약]
- N x N 배열을 입력받아 90도, 180도, 270도 회전한 결과를 각각 출력한다.

[회전 공식]
90도  : rotated[j][N - 1 - i] = arr[i][j];
180도 : rotated[N - 1 - i][N - 1 - j] = arr[i][j];
270도 : rotated[N - 1 - j][i] = arr[i][j];

*/
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 한변의 길이

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] rotated90 = new int[N][N];// 90도 회전 배열
			int[][] rotated180 = new int[N][N];// 180도 회전 배열
			int[][] rotated270 = new int[N][N];// 270도 회전 배열

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					rotated90[j][N - 1 - i] = arr[i][j];
					rotated180[N - 1 - i][N - 1 - j] = arr[i][j];
					rotated270[N - 1 - j][i] = arr[i][j];
				}
			}

			// 출력
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				StringBuilder sb = new StringBuilder();

				// 90
				for (int j = 0; j < N; j++) {
					sb.append(rotated90[i][j]);
				}
				sb.append(" ");
				// 180
				for (int j = 0; j < N; j++) {
					sb.append(rotated180[i][j]);
				}
				sb.append(" ");
				// 270
				for (int j = 0; j < N; j++) {
					sb.append(rotated270[i][j]);
				}
				System.out.println(sb);
			}

		}
	}
}