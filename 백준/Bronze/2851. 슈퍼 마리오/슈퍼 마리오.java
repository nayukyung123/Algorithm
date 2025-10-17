import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2851 슈퍼마리오 
// 합이 최대한 100에 가깝게 만들기 

public class Main {

	static int getScore(int[] score) {
		int ans = 0;
		int sum = 0;

		for (int i = 0; i < score.length; i++) {
			sum += score[i];
			if (Math.abs(100 - sum) <= Math.abs(100 - ans)) {
				ans = sum;
			}
		}
		
		return ans;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] score = new int[10];
		for (int i = 0; i < 10; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}

		int result = getScore(score);
		System.out.println(result);

	}

}
