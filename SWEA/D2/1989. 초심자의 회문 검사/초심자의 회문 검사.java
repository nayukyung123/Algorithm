import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int len = str.length();
			// 문자열 뒤집기
			String backstr = new StringBuilder(str).reverse().toString();

			// str = backstr -> 회문이니까 1출력
			if (str.equals(backstr)) {
				System.out.println("#" + tc + " " + "1");
			} else
				System.out.println("#" + tc + " " + "0");
		}

	}

}
