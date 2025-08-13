
import java.io.*;
import java.util.*;

public class Solution {

	private static char[] inputArr;
	private static int N;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //정점의 총수
			inputArr = new char[N+1];// 0번째를 버리고 1번 인덱스부터 정점으로 사용가능
            // StringToknizer를 사용해서 다음 문자열이 있는지 체크해서 받기
			sc.nextLine();
			for (int i = 1; i <= N ; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				st.nextToken();
				inputArr[i] = st.nextToken().charAt(0);
			}
			System.out.print("#" + tc + " ");
			inOrder(1);
			System.out.println();
		}
	}
// 방문체크, 범위를 벗어나지 않았는지, 자식노드가 더 존재하는지 등 체크가능
	private static void inOrder(int i) {
		if (i <= N) {
			inOrder(i * 2);// 중위순회 이므로 좌측자식노드부터 끝까지 탐색
			System.out.print(inputArr[i]);// 좌측노드 탐색후 부모노드의 값을 출력
			inOrder(i * 2 + 1); // 부모노드 탐색후 우측노트 탐색
		}
		
	}
}
