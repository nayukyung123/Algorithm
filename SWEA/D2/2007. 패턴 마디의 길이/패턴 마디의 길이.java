import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine(); 
			int strLen = str.length();
			int ans = 0; 
			
			for (int i = 1; i <= 10; i++) {
				String pattern = str.substring(0, i); 
				String check = str.substring(i, i+i);
				
				if (pattern.equals(check)) {
					ans = i;
					break;
				}
				
			}
			System.out.println("#" + tc + " " + ans);
		}
		
	}

}
