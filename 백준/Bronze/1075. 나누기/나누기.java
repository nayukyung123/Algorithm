import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//입력받기
		Scanner	sc = new Scanner(System.in);
		int N = sc.nextInt();
		int F = sc.nextInt();
		
		int base = (N / 100) * 100; // 뒤 두자리를 00으로 만든
		
		for (int i = 0; i < 100; i++) { //00 ~ 99 까 완전탐색 
			int A = base + i;			//뒤 두자리를 i로 바꾸었음 
			if (A % F == 0) {			//F로 나누어 떨어지는지 확인 
				System.out.printf("%02d\n", i); //뒤 두자리만 출력 
				break;
			}
		}
		

	}

}