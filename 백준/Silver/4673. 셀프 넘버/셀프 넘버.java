import java.util.Scanner;
import java.util.Set;

public class Main {

	public static int d(int n) {
		int sum = n;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		boolean[] isGenerated = new boolean[10001];
		
		for (int i = 1; i <= 10000; i++) {
			int dn = d(i);
			if (dn <= 10000) {
				isGenerated[dn] =true;
			}
			
		}
		for (int i = 1; i <= 10000; i++) {
			if (!isGenerated[i]) {
				System.out.println(i);
			}
			
		}

	}
}