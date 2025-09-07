import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			int remainder = 0; // 나머지
			remainder = arr[i] % 42;
			set.add(remainder);
		}
		System.out.println(set.size());

	}

}
