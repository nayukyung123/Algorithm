import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			Set<Integer> set = new HashSet<>();
			
			int cnt = 0;
			int result = 0;
			
			while (set.size()<10) {
				 result = N * ++cnt; // int형 한 글자 씩 빼오는 법 
				 String s = String.valueOf(result); // int -> String 
				 for (char c : s.toCharArray()) { // toCharArray 문자열을 문자 하나씩 잘라서 배열에 담아줌
					set.add(c -'0');
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}
