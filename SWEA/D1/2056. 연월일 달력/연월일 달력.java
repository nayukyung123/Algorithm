
import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;

public class Solution {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 받은 메세지를 낸,월, 일로 받자
			String str = br.readLine();
			String yearStr = str.substring(0, 4);
			String monthStr = str.substring(4, 6);
			String dayStr = str.substring(6, 8);

			// String -> int
			int year = Integer.parseInt(yearStr);
			int month = Integer.parseInt(monthStr);
			int day = Integer.parseInt(dayStr);

			// month 유효성 판단
			if (month < 1 || month > 12) {
				System.out.println("#" + tc + " " + "-1");
				continue;
			}
			// day 유효성 판단
			switch (month) {
			case 1:
			case 3:
			case 5: 
			case 7:
			case 8:
			case 10:
			case 12:
				if (day == 0 || day > 31) {
					System.out.println("#" + tc + " " + "-1");
					break;
				} else {
					System.out.println("#" + tc + " " + yearStr + "/" + monthStr + "/" + dayStr);
					break;
				}

			case 4:
			case 6:
			case 9:
			case 11:
				if (day == 0 || day > 30) {
					System.out.println("#" + tc + " " + "-1");
					break;
				} else {
					System.out.println("#" + tc + " " + yearStr + "/" + monthStr + "/" + dayStr);
					break;
				}

			case 2:
				if (day == 0 || day > 28) {
					System.out.println("#" + tc + " " + "-1");
					break;
				} else {
					System.out.println("#" + tc + " " + yearStr + "/" + monthStr + "/" + dayStr);
					break;
				}

			}

		}

	}
}
