import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    // 4방향 이동을 위한 행/열 변화량
    final static int[] dr = {-1, 1, 0, 0}; // 위, 아래
    final static int[] dc = {0, 0, -1, 1}; // 왼쪽, 오른쪽
    final static int SIZE = 10; // 게임 맵의 크기 (10x10 고정)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기: 시작 위치 (사람이 있는 좌표)
        String[] strArr = br.readLine().split(" "); // 공백으로 분리
        int[] pos = {
            Integer.parseInt(strArr[0]) - 1, // 입력이 1부터 시작하므로 0-based로 맞춤 (행)
            Integer.parseInt(strArr[1]) - 1  // 입력이 1부터 시작하므로 0-based로 맞춤 (열)
        };

        // 게임판 정보 입력 (폭탄이 있는 곳: 'o', 없는 곳: 'x')
        char[][] map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = br.readLine().toCharArray(); // 한 줄을 문자 배열로 저장
        }

        // 안전지점까지 최소 이동 거리 계산
        System.out.println(solution(pos, map));

        br.close();
    }

    // 안전한 지점까지 최소 몇 번만에 갈 수 있는지 계산 (BFS 탐색)
    private static int solution(int[] pos, char[][] map) {
        int answer = 0;

        // 우선순위 큐: step(이동 횟수)가 적은 순으로 꺼냄 (최단 거리 탐색 목적)
        PriorityQueue<Bazzi> pq = new PriorityQueue<>();
        pq.offer(new Bazzi(pos[0], pos[1], 0)); // 현재 위치를 큐에 넣음 (행, 열, 이동 수)

        // 방문 여부를 기록할 배열
        int[][] visit = new int[SIZE][SIZE];
        visit[pos[0]][pos[1]] = 1; // 시작 위치는 방문 처리

        // BFS 탐색 시작
        while (!pq.isEmpty()) {
            Bazzi current = pq.poll(); // 이동 횟수가 가장 적은 위치 꺼냄

            // 현재 위치가 안전한지 확인
            if (isSafe(current, map)) {
                answer = current.step; // 도달한 순간의 이동 횟수를 답으로 저장
                break; // 더 이상 탐색할 필요 없음
            }

            // 4방향 이동 시도 (위, 아래, 왼쪽, 오른쪽)
            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i]; // 새로 이동할 행
                int nc = current.c + dc[i]; // 새로 이동할 열

                // 맵 안에 있고, 방문하지 않은 곳만 탐색
                if (isInArea(nr, nc) && visit[nr][nc] == 0) {
                    visit[nr][nc] = 1; // 방문 처리
                    pq.offer(new Bazzi(nr, nc, current.step + 1)); // 다음 위치 큐에 추가
                }
            }
        }

        return answer;
    }

    // 좌표가 맵 내부에 있는지 확인
    private static boolean isInArea(int r, int c) {
        return r >= 0 && r < SIZE && c >= 0 && c < SIZE;
    }

    // 현재 위치가 안전한지 확인
    // 같은 행이나 열에 폭탄(o)이 있으면 위험
    private static boolean isSafe(Bazzi b, char[][] map) {
        // 세로(열 고정, 행만 변화) 확인
        for (int i = 0; i < SIZE; i++) {
            if (map[i][b.c] == 'o') return false;
        }

        // 가로(행 고정, 열만 변화) 확인
        for (int i = 0; i < SIZE; i++) {
            if (map[b.r][i] == 'o') return false;
        }

        // 폭탄이 없는 안전한 위치
        return true;
    }
}

// 위치(r, c)와 이동 횟수(step)를 저장하는 클래스
// Comparable을 구현해 이동 횟수가 적은 순서대로 정렬됨
class Bazzi implements Comparable<Bazzi> {
    int r; // 행(row)
    int c; // 열(col)
    int step; // 이동 횟수

    public Bazzi(int r, int c, int step) {
        this.r = r;
        this.c = c;
        this.step = step;
    }

    @Override
    public int compareTo(Bazzi other) {
        return Integer.compare(this.step, other.step); // 이동 수 기준 오름차순 정렬
    }
}
