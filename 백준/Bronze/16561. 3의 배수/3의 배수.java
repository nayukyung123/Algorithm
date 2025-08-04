import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;

		// i = 첫 번째 3의 배수 자연수, j = 두번쩨
		for (int i = 3; i <= n - 6; i += 3) {
			for (int j = 3; j <= n - i - 3; j += 3) {
				int k = n - i - j;
				//k도 3의 배수이고 최소 3 이상이어야 유효 
			if (k >= 3 && k % 3 == 0) {
				count++;
			}

			}

		}
		System.out.println(count);
	}
}
