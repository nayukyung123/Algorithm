
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();//양이 하루 먹는 사료 
		int b = sc.nextInt();//염소가 하루 먹는 사료
		int n = sc.nextInt();// 전체 가축 수 
		int w = sc.nextInt();//총 소비 사료
		
		int count = 0; //해의 갯수 
		int ansX = -1, ansY = -1; // 양(x)과 염소(y) 초기 (아직 해를 못 찾았다)
		
		//x = 몇마리의 양인지, 최소 1마리 최대 n-1 마리
		for (int x = 1; x < n; x++) {
			int y = n - x;
			if(a * x + b * y == w) {
				count++;
				ansX = x;
				ansY = y;
			}
			
		}
		
		// 해가 하나여야함   
		if (count == 1) {
			System.out.printf("%d %d\n", ansX, ansY);
		} else {
			System.out.println(-1);
		}
	}
}
