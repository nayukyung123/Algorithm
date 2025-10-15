import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2798_블랙잭 
// Brute Force
// 세 장의 합을 구하고
// M 이하면
// max 값을 갱신
public class Main {

	static int[] cards;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		int max = 0;
		
		// 모든 3장의 조합 
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					sum = cards[i]+cards[j]+cards[k];
					// M 보다 작거나 같을 때 
					if (sum <= M) {
						max = Math.max(sum, max);
					}
				}
			}

		}

		System.out.println(max);
	}

}
