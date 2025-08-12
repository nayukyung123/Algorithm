import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int t = sc.nextInt();
			// 큐에 8숫자 넣기
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}

			// 감소한다
			int dec = 1;
			while (true) {
				// 맨 앞에서 꺼내 감소
				// 0 이하이면
				// 0붙이고 종료
				// 아니면 뒤에 붙이기
				// 감소값 증가
				// 1~5순환
				int num = q.poll() - dec;
				if (num <= 0) {
					q.offer(0);
					break;

				} else {
					q.offer(num);
				}
				dec++;
				if(dec == 6) dec =1; // 6이 되면 1로 바꿔

			}
			//출력
			System.out.print("#" + t);
			for (int val : q) {
				System.out.print(" " + val);
			}
			System.out.println();
			
		}

	}

}
