
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int strLen = 0;
			
			for (int len = 1; len <= 10; len++) {
				String pattern = str.substring(0,len);
				String next = str.substring(len, 2 * len);
				
				if(pattern.equals(next)) {
					strLen = len;
					break;
				}
			}
			System.out.println("#" + tc + " " + strLen);
		}

	}

}
