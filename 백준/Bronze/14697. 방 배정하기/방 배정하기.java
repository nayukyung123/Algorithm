import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // 1 번방
		int B = sc.nextInt(); // 2 번방
		int C = sc.nextInt(); // 3 번방
		int N = sc.nextInt(); // 전체 학생 수

		int possible = 0; // 방 배정 실패 

        // i: A방 수, j: B방 수, k: C방 수
		for (int i = 0; i <= N / A; i++) {
			for (int j = 0; j <= N / B; j++) {
				for (int k = 0; k <= N / C; k++) {
					// 빈 침대 없이 정확하게 할당 가능한가?????
					if (i * A + j * B + k * C == N) {
						possible = 1; //방 배정 성공 
						break;
					}

				}
				if (possible == 1)break;

			}
			if (possible == 1)break;

		}
		System.out.println(possible);
	}
}
