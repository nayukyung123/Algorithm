import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int r = sc.nextInt();
			String s = sc.next();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				for (int j = 0; j < r; j++) {
					System.out.print(c);
				}
			}
			System.out.println();

		}

	}

}
