import java.util.Scanner;

//이 문제 는 Math 라이브러리 못 쓰더
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int[] r = new int[4]; // 빨간칸 좌표
			for (int i = 0; i < 4; i++) {
				r[i] = sc.nextInt();
			}

			int[] c = new int[4]; // 파란칸 좌표
			for (int j = 0; j < 4; j++) {
				c[j] = sc.nextInt();
			}

			// 겹치는 영역의 좌표 계산
//			int x_overlap_start = Math.max(r[0], c[0]);
//          int y_overlap_start = Math.max(r[1], c[1]);
//          int x_overlap_end = Math.min(r[2], c[2]);
//          int y_overlap_end = Math.min(r[3], c[3]);
			int x_start, y_start, x_end, y_end;

			if (r[0] > c[0]) {
				x_start = r[0];
			} else {
				x_start = c[0];
			}

			if (r[1] > c[1]) {
				y_start = r[1];
			} else {
				y_start = c[1];
			}
			
			// Math.min() 대신 직접 비교
			if (r[2] < c[2]) {
				x_end = r[2];
			} else {
				x_end = c[2];
			}
			
			if (r[3] < c[3]) {
				y_end = r[3];
			} else {
				y_end = c[3];
			}
			

			// 보라칸좌표
			int w = 0;
			int h = 0;

			// 겹치는 영역이 있는 경우에만 너비(w), 높이(h) 계산
			if (x_end >= x_start && y_end >= y_start) {
				w = (x_end - x_start) + 1;
				h = (y_end - y_start) + 1;
			}


			System.out.println("#" + tc + " " + h + " " + w);

		}

	}
}
