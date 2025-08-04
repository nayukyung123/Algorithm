import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// "DD:DD;DD"형태 문자열을 읽고, ":"단위로 분리
		String[] parts = br.readLine().split(":");
		int cnt = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					// i,j,k는 서로 다른 순서여야한다
					if (i == j || j == k || i == k)
						continue;

					int x = Integer.parseInt(parts[i]);
					int y = Integer.parseInt(parts[j]);
					int z = Integer.parseInt(parts[k]);

					// 시는 1~12, 분과 초는 0~59 조건 검사
					if (x >= 1 && x <= 12 && y >= 0 && y <= 59 && z >= 0 && z <= 59) {
						cnt++;
					}

				}
			}
		}
		System.out.println(cnt);
	}
}
