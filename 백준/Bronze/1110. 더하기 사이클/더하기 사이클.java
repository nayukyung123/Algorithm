import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int init = sc.nextInt();// 초기 입력값 저장
		int N = init; 
		int count = 0; // 사이클 카운트

		while (true) {
			int a = N / 10;// N의 십의 자리
			int b = N % 10;// N의 일의지리
			int c = (a + b) % 10;// 두 자리 합의 일의 자리
			N = b * 10 + c;// 새로운 값 생성
			count++;// 사이클 횟수 증가
			if (N == init)
				break;// 초기화 값으로 돌아오면 반복종료
		}
		System.out.println(count);

	}
}