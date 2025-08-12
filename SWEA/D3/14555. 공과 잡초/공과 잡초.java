
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();

			int result = 0;

			for (int index = 0; index < str.length(); index++) {
				char c = str.charAt(index);
				if (c == '(') {

					result++; // 열린 괄호면 공으로 간주
				} else if (c == ')') {
                    // 현재 문자가 닫는 괄호 ')'일 때
                    // 이전 문자가 '|'이면 카운트 증가
                    // (index > 0 조건: 이전 문자가 존재해야 함)
					if (index > 0 && str.charAt(index - 1) == '|') {

						result++;
					}
				}

			}
			System.out.println("#" + test_case + " " + result);

		}
	}

}