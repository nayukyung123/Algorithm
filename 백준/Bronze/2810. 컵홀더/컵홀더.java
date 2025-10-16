import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2810_컵홀더

// 커플석은 한번만 카운트 하고 다음 인덱스는 건너 뛰기
// 좌석 당 컵홀더 증가 
// 사람이 5명이고 컵 홀더가 4이면 더 작은 값이니까 4명이 사용가능한거고  --> min
// 반대로 사람이 5명이고 컵 홀더가 6인건 판별 안 해도 됨 
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String seats = br.readLine();

		int ans = 1; // 양끝에 컵홀더 존재
		for (int i = 0; i < seats.length(); i++) {
			if (seats.charAt(i) == 'S') {
				ans++;
			} else if (seats.charAt(i) == 'L') {
				ans++;
				i++; // 커플석은 두 칸을 한 번에 처리 -> 한칸 더 이동
			}
		}

		System.out.println(Math.min(ans, N));
	}

}
