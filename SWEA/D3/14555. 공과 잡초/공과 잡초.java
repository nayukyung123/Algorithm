import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String S = br.readLine();
			// 만약 ( 다음 | 이거나 ) 이거면
			// 잡초 수 증가
			// 문장의 한글자...

			int cnt = 0; // 잡초
			for (int i = 0; i < S.length() - 1; i++) {
				char c = S.charAt(i);
				if (c == '(') {
					if (S.charAt(i+1) == '|' || S.charAt(i+1) == ')') {
						cnt++;
					}
				}
				if( c =='|') {
					if(S.charAt(i+1) == ')')
						cnt++;
				}
					
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
