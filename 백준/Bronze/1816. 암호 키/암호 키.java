import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			long num = sc.nextLong();
			
			boolean isEncrypted = true;
			
			for (int d = 2; d <= 1000000 ; d++) {
				if(d * d > num) break;
				
				if (num % d == 0) {
					isEncrypted = false;
					break;
				}
			}
			if (isEncrypted) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
		
	
	}
}
