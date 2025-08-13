import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int tc = 1; tc <= T ; tc++) {
			int N = sc.nextInt();//원본 암호문 뭉치 길이
			LinkedList<Integer> list = new LinkedList<Integer>(); //삽입/삭제많아서 LinkedList
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt()); //원본 암호문 뭉치 저장
			}
			
			int M = sc.nextInt(); //명령어 개수
			for (int cmdCnt = 0; cmdCnt < M; cmdCnt++) {
				String cmd = sc.next(); 
				switch (cmd) {
				case "I": { //삽입명령
					int x = sc.nextInt(); //삽입할 위치 인덱스
					int y = sc.nextInt(); //삽입할 개수
					
					//x가 범위를 벗어나는 경우 방지
					if (x < 0) x =0;
					if( x > list.size()) x = list.size();
					
					//커서를 x위치에 둔 뒤 순서대로 add
					ListIterator<Integer> it = list.listIterator(x);
					for (int k = 0; k < y; k++) {
						it.add(sc.nextInt()); // 현재 커서 위치에 삽입 후 커서가 오른쪽으로 이동
					}
					break;
				}
				case "D": { //삭제명령
					int x = sc.nextInt(); //삭제 시작 인덱스
					int y = sc.nextInt(); //삭제할 개수
					
					//x가 범위를 벗어나는 경우 방지
					if (x < 0) x =0;
					if( x > list.size()) x = list.size();
					
					//커서를 x위치에 둔 뒤, y번 next() -> remove()
					ListIterator<Integer> it = list.listIterator(x);
					for (int k = 0; k < y && it.hasNext(); k++) {
						it.next();//삭제할 원소로 이동
						it.remove(); //현재 위치 원소 삭제
					}
					break;
				}
				case "A": { //추가명령
					int y = sc.nextInt(); //뒤에 붙일 개수
					for (int k = 0; k < y; k++) {
						list.addLast(sc.nextInt());//리스트 맨 뒤에 추가 
					}
					break;
				}
				
				default:
					break;
				}
			}
			// [4] 결과 출력 (앞 10개만)
			System.out.print("#" + tc); // 테스트 케이스 번호 출력

			int howMany = Math.min(10, list.size()); // 최대 10개만
			Iterator<Integer> it = list.iterator();
			for (int i = 0; i < howMany; i++) {
			    System.out.print(" " + it.next()); // 앞에서부터 하나씩 공백과 함께 출력
			}
			System.out.println(); // 줄바꿈

			
		}

	}

}
