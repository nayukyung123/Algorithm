import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int distance = 0;
			int speed = 0;

			for (int i = 0; i < N; i++) {
				int move = sc.nextInt();
				if (move == 1) { // 가속
					int upspeed = sc.nextInt();
					speed += upspeed;
				} else if (move == 2) { // 감속
					int downspeed = sc.nextInt();
					speed -= downspeed;
					if (speed < 0)
						speed = 0;
				}
				distance += speed;
			}
			System.out.println("#" + tc + " " + distance);
		}
	}
}