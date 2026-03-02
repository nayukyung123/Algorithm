import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


	static int N, K, L;
	static int[][] board;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0, 1, 0, -1};
	static Map<Integer, String> truns = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		board = new int[N + 1][N +1];
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r][c] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			truns.put(time, dir);
		}
		
		// 뱀의 몸통 만들기 
		// 시작 세팅 
		
		Deque<int[]> snake = new LinkedList<>();
		snake.add(new int[] {1,1});
		board[1][1] = 2;
		
		int dir = 1;
		int time  = 0;

		// 뱀이 움직인다
		while (true) {
			time++; // 1초 
			
			int[] head = snake.peekFirst();
			int nr = head[0] + dr[dir];
			int nc = head[1] + dc[dir];
			
			// 벽에 박거나 몸에 부닺히면 끝 
			if(nr < 1 || nr > N || nc < 1 || nc  > N || board[nr][nc] == 2) {
				break;
			}
			
			// 머리를 다음 칸에 넣기 
			snake.addFirst(new int[] {nr,nc});
			
			// 이동 한 곳에 사과가 있는지 확인 
			// 항상 머리 추가
			// 사과 없을 때만 꼬리를 제거 
			if(board[nr][nc] == 1) {
				board[nr][nc] = 2; // 사과가 있다면 꼬리를 자르지 않는다  
			}else {
				board[nr][nc] = 2; 
				int[] tail = snake.pollLast(); //  꼬리 빼기 
				board[tail[0]][tail[1]] = 0; // 보드에서 꼬리 지우기 
			}
			
			// 방향전환 
			if( truns.containsKey(time)) {
				String nextDir = truns.get(time);
				if(nextDir.equals("D")) {
					dir = (dir+1) % 4;
				}else {
					dir = (dir + 3) % 4;
				}
			}
		}
		System.out.println(time); 
	}
}
