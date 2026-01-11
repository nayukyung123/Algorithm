import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 하나의 숫자를받으면 그 숫자만큼의큐가 생성이 되고
		// 제일먼저 들어온 것 부터 버리고 다음수를 뒤로가게
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}

		while (q.size() > 1) {
			q.poll();
			q.offer(q.poll());
		}
		
		System.out.println(q.poll());
	}
}

