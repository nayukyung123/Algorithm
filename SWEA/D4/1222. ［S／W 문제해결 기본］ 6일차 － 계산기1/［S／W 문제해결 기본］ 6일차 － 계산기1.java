import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int inputLength = Integer.parseInt(br.readLine());
			String inputStr = br.readLine();//문자열로 받음

			Stack<Character> stack = new Stack<>();// 스택
			String postfix ="";//문자열
			int sum = 0; // 정답 숫자들 다 더한값
			for (int i = 0; i < inputLength; i++) {
				char c = inputStr.charAt(i);
				// 피연산자
				if (c >= '0' && c <= '9') {
					postfix +=c;
					sum+=(c-'0'); //문자열 -> 숫자 
				} // 연산자일경우
				else {
					stack.push(c);
				}
			}
			System.out.println("#" + tc + " " + sum);

		}

	}
}
