import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 감속 시 속도는 0 밑으로 내려가지 않게 조정
 모든 명령마다 ans += speed 로 이동거리 누적
*/
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 커맨드 수

			int ans = 0; // 이동거리
			int speed = 0; // 속도

			for (int i = 0; i < N; i++) { // N번 입력 받겠다
				StringTokenizer st = new StringTokenizer(br.readLine());
				int cmd1 = Integer.parseInt(st.nextToken());

				if (cmd1 == 0) {
					ans += speed; // 속도 유지 중 계속 이동 !!
					continue;
				}

				if (cmd1 == 1) {
					int cmd2 = Integer.parseInt(st.nextToken());
					speed += cmd2;
					ans += speed;
				}

				if (cmd1 == 2) {
					int cmd2 = Integer.parseInt(st.nextToken());
					speed -= cmd2;
					if (speed < 0) { //  현재 속도보다 감속할 속도가 더 클 경우, 속도는 0 m/s 가 된다
						speed = 0;
					}
					ans += speed;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}