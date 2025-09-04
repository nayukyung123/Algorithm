import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int suNo = Integer.parseInt(stringTokenizer.nextToken()); // N
		int quizNo = Integer.parseInt(stringTokenizer.nextToken()); // M

		long[] S = new long[suNo + 1]; // 누적합, 크기를 N+1로 해서 S[0] = 0을 쓸 수 있게 함
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 1; i <= suNo; i++) {
			S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
		} // 채우기

		for (int q = 0; q < quizNo; q++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int i = Integer.parseInt(stringTokenizer.nextToken());// 구간 시작
			int j = Integer.parseInt(stringTokenizer.nextToken());// 구간 끝
			System.out.println(S[j] - S[i - 1]);
		}
	}
}