import java.io.*;
import java.util.*;

import org.w3c.dom.css.CSSFontFaceRule;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String[]arr = new String[5];
			int maxLen = 0;
			
			for (int i = 0; i < 5; i++) {
				arr[i] = sc.next();
				maxLen = Math.max(maxLen, arr[i].length());
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < maxLen; j++) {
				for (int i = 0; i < arr.length; i++) {
					if(j < arr[i].length())
						sb.append(arr[i].charAt(j));
				}
			}
			System.out.println("#" + tc + " " +sb.toString());
			
		}

	}

}