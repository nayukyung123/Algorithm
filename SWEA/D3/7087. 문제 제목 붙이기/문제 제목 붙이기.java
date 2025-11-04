import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			String[] input = new String[n];
			for (int i = 0; i < n; i++) {
				input[i] = br.readLine(); // Air , Dad , Ear, Blue, Ace
			}

			Arrays.sort(input);// 알파벳 순 정렬 //Air , Ace, Blue, BlueDad , Ear

			int cnt = 0;// 결과
			char expected = 'A'; // 예상 알파벳
			char prev = ' '; // 전 알파벳의 앞글자
			for (int i = 0; i < n; i++) {
				String first = input[i].substring(0, 1);
				char c = first.charAt(0);

				if (c != prev) { // 첫 등장
					if (c == expected) {// 예상 알파벳 이면 카운트 증가 후 다음 알파벳으로 넘김
						cnt++;
						expected++;
					} else {
						break;// 예상 한 것이 아니면 중단
					}
					prev = c;//나왔던거라면 알파벳의 앞 글자 갱신 
				}  
					
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}


