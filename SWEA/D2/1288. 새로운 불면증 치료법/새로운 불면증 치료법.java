import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for (int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(sc.nextLine());
			Set<Character> seen = new HashSet<>();
			long k = 0;
			
			while (seen.size() < 10) {
				long x = N * ++k;
				for (char c : String.valueOf(x).toCharArray()) {
					seen.add(c);
				}
			}
			System.out.println("#" + tc + " " + k*N);
		}

	}
}
