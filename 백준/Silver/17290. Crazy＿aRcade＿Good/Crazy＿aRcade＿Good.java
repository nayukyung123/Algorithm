import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	// 상하좌우 방향 벡터
	final static int[] dx = { 1, 0, -1, 0 };
	final static int[] dy = { 0, 1, 0, -1 };
	final static int SIZE = 10; // 맵 크기: 10x10

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력: 시작 위치 (y, x)
		String[] strArr = br.readLine().split(" ");
		int[] pos = { Integer.parseInt(strArr[0]) - 1, // y 좌표 (0-based)
				Integer.parseInt(strArr[1]) - 1 // x 좌표 (0-based)
		};

		// 맵 정보 저장
		char[][] map = new char[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			map[i] = br.readLine().toCharArray(); // 한 줄을 char 배열로 변환
		}

		// BFS 탐색 결과 출력
		System.out.println(solution(pos, map));

		br.close();
	}

	// BFS를 활용해 안전한 지점까지의 최소 이동 횟수 탐색
	private static int solution(int[] pos, char[][] map) {
		int answer = 0;

		// 이동 횟수가 작은 순으로 탐색하기 위한 우선순위 큐
		PriorityQueue<Bazzi> pq = new PriorityQueue<>();
		pq.offer(new Bazzi(pos[1], pos[0], 0)); // 시작 지점 (x, y, step)

		int[][] visit = new int[SIZE][SIZE];
		visit[pos[0]][pos[1]] = 1; // 시작 지점 방문 표시

		while (!pq.isEmpty()) {
			Bazzi bazzi = pq.poll(); // 현재 위치 꺼냄

			// 현재 위치가 안전한지 검사
			if (isSafe(bazzi, map)) {
				answer = bazzi.step;
				break; // 첫 안전지점 발견 시 종료
			}

			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int ny = bazzi.y + dy[i];
				int nx = bazzi.x + dx[i];

				// 유효한 범위이고 아직 방문하지 않은 경우
				if (isInArea(nx, ny) && visit[ny][nx] == 0) {
					visit[ny][nx] = 1; // 방문 처리
					int step = bazzi.step + 1; // 이동 횟수 증가
					pq.offer(new Bazzi(nx, ny, step)); // 다음 위치 추가
				}
			}
		}

		return answer;
	}

	// 맵 범위 내에 있는지 확인
	private static boolean isInArea(int nx, int ny) {
		return nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE;
	}

	// 해당 위치가 폭탄 영향을 안 받는지 검사
	private static boolean isSafe(Bazzi bazzi, char[][] map) {
		// 같은 열(x)에 폭탄이 있는지 확인
		for (int i = 0; i < SIZE; i++) {
			if (map[i][bazzi.x] == 'o')
				return false;
		}

		// 같은 행(y)에 폭탄이 있는지 확인
		for (int i = 0; i < SIZE; i++) {
			if (map[bazzi.y][i] == 'o')
				return false;
		}

		return true;
	}
}

// BFS를 위한 위치 + 이동 횟수 저장 클래스
class Bazzi implements Comparable<Bazzi> {
	int x; // x 좌표
	int y; // y 좌표
	int step; // 이동 횟수

	public Bazzi(int x, int y, int step) {
		this.x = x;
		this.y = y;
		this.step = step;
	}

	// 이동 횟수가 적은 Bazzi가 우선순위를 갖도록 정렬
	@Override
	public int compareTo(Bazzi b) {
		return this.step > b.step ? 1 : -1;
	}
}