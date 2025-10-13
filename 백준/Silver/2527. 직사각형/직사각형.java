import java.io.*;
import java.util.*;

// 조건 분기 if else
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());

			// 공통부분이 없음 d
			if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
				System.out.println("d");
			}
			// 점 c
			else if ((p1 == x2 && q1 == y2) ||
                    (x1 == p2 && q1 == y2) ||
                    (p1 == x2 && y1 == q2) ||
                    (x1 == p2 && y1 == q2)) {
               System.out.println("c");
           }
			// 선분 b
			else if (p1 == x2 || x1 == p2 || q1 == y2 || y1 == q2) {
				System.out.println("b");
			}
			// 직사각형 a
			else {
				System.out.println("a");
			}

		}

	}
}