import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
		int d = sc.nextInt(), e = sc.nextInt(), f = sc.nextInt();
		
		for (int x = -999; x <= 999; x++) {
			for (int y = -999; y <= 999; y++) {
				if (a * x + b * y == c && d * x + e * y  == f) {
					System.out.println(x + " " + y);
					return;
				}
				
			}
			
		}
	}
}
