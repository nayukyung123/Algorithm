
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			String[] cards = new String[N];
			for (int i = 0; i < cards.length; i++) {
				cards[i] = sc.next();
			}
			
			int mid = (N + 1)/2;
			String[] result  = new String[N];
			int i = 0; //앞 절반 인덱스
			int j = mid;  //뒷 절반 인덱스
			int k = 0;
			
			while (i < mid || j < N) {
				if(i < mid) result[k++] = cards[i++];
				if(j < N) result[k++] = cards[j++];
			}
			
			System.out.print("#" + tc + " ");
			System.out.println(String.join(" ", result)); //공백 구분 출력
		}
	}

}
