import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2999_비밀이메일
// 1. N 의 약수를 찾고
// 2. 세로(열)로 채운뒤 
// 3. 가로(행)로 읽는다 
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int N = str.length();

		int R = 1; // 초기값 (최악의 경우 1 x N)
		int C = N;

		// 행렬조합 찾기
		// 1
		for (int i = 1; i <= Math.sqrt(N); i++) {
			if (N % i == 0) { // 약수이면
				int j = N / i; // 짝이 되는 수를 j에 넣는다
				if (i <= j) {
					R = i;
					C = j;
				}
			}
		}

		// 2
		char[][] map = new char[R][C];
		int idx = 0;
		for (int c = 0; c < C; c++) {
			for (int r = 0; r < R; r++) {
				map[r][c]= str.charAt(idx++);
			}

		}

		// 3
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sb.append(map[r][c]);
			}
		}
		// 출력하기
		System.out.println(sb);

	}

}
