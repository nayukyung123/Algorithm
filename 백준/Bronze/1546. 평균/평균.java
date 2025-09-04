import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		} // 점수 저장하기

		long sum = 0;
		long max = 0;

		for (int i = 0; i < N; i++) {
			if (A[i] > max) max = A[i]; // max값 갱신
			sum = sum + A[i]; // sum값 갱신

		}
		System.out.println(sum*100.0/max/N);
	}

}
