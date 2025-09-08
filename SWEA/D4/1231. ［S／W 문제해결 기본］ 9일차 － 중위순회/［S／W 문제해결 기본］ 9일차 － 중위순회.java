import java.util.*;
import java.io.*;

public class Solution {

	static int n; // 정점 수
	static char[] tree; // 노드 문자 저장 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			n = sc.nextInt(); // 정점 개수
			tree = new char[n + 1]; // 1번부터 n번까지 사용
			
			//각 노드 정보 입력(노드번호, 문자, 자식정보)
			for (int i = 1; i <=n; i++) {
				sc.nextInt(); // 노드번호 버리기
				tree[i] = sc.next().charAt(0); // 문자만 저장 
				sc.nextLine(); // 자식정보 버리기
				
			}

			System.out.print("#" + tc + " ");
			inorder(1); // 루트(1)부터 중위순회 시작
			System.out.println();

		}
	}

	static void inorder(int idx) {
		if (idx > n)  // 범위 벗어나면 종료
			return;// 더 이상 노드가 없으면 종료
		inorder(idx * 2); // 왼쪽 자식
		System.out.print(tree[idx]); // 현재 노드 출력
		inorder(idx * 2 + 1); // 오른쪽 자식
	}

}
