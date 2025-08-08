import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int inputNums = sc.nextInt();
			sc.nextLine();    
			String infix = sc.nextLine(); // 중위
			StringBuffer postfix = new StringBuffer(); // 후위(피연산자)
			Map<Character, Integer> priority = new HashMap<>(); // 피연산자 우선순위
			priority.put('*', 2);
			priority.put('+', 1);
			priority.put('(', 0);
			priority.put(')', 0);

			Stack<Character> stack = new Stack<>(); // 스택(연산자)
			// 중위 -> 후위
			for (int i = 0; i < inputNums; i++) {
				char tmp = infix.charAt(i);
				// 피연산자
				if (tmp >= '0' && tmp <= '9') {
					postfix.append(tmp);
				} else if (tmp == '(') {
					stack.push(tmp);
				} else if (tmp == ')') {
					while (!stack.isEmpty()&&stack.peek() != '(') {
						postfix.append(stack.pop());
					}
					stack.pop();
				} else {
					if (stack.isEmpty()) {
						stack.push(tmp);
					} else {
						while (!stack.isEmpty()&&priority.get(stack.peek()) >= priority.get(infix.charAt(i))) {
							postfix.append(stack.pop());
						}
						stack.push(infix.charAt(i));
					}
				}

			}
			while (!stack.isEmpty())
				postfix.append(stack.pop());
			// 후위 계산
			Stack<Integer> calc = new Stack<>();
			for (int i = 0; i < postfix.length(); i++) {
				char c = postfix.charAt(i);
				if (c >= '0' && c <= '9') {
					calc.push(postfix.charAt(i) - '0');
				} else {
					int B = calc.pop();
					int A = calc.pop();

					switch (postfix.charAt(i)) {
					case '+':
						calc.push(A + B);
						break;
					case '*':
						calc.push(A * B);
						break;
					}
				}

			}
			System.out.println("#" + tc + " " + calc.pop());
		}
	}
}
