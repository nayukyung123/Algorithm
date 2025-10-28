import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int posO = 1;
			int posB = 1;
			int timeO = 0;
			int timeB = 0;
			
			for (int i = 0; i < N; i++) {
				String robot = st.nextToken();
				int targetButton = Integer.parseInt(st.nextToken());
				
				if(robot.equals("O")) {
					int dist = Math.abs(targetButton - posO);
					timeO = Math.max(timeO + dist, timeB) + 1;
					posO = targetButton;
				}else {
					int dist = Math.abs(targetButton - posB);
					timeB = Math.max(timeB + dist, timeO) + 1;
					posB = targetButton;
				}
				
			}
			int totalTime = Math.max(timeO, timeB);
			System.out.println("#" + tc + " " + totalTime);
		}
	}
}
