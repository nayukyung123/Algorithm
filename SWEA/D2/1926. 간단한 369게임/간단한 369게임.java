import java.util.*;

class Solution {


	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {  
			String s = String.valueOf(i);//숫자 -> 문자열
			int clap = 0; //박수

			//현재 숫자의 각 자리 확인
			for (int index = 0; index < s.length(); index++) {
				char c = s.charAt(index); //index번째 문자
				if (c == '3' || c == '6' || c == '9') {
					clap++;
				}
			}

			
			if (clap > 0) {
                //clap수 만큼 "-"출력
				for (int k = 0; k < clap; k++) {
					System.out.print("-");
				}
				System.out.print(" ");
			} else {
				System.out.print(i + " ");
			}
		}
	}
}