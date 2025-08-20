import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int max = arr[0]; // 인덱스로 가져오기 
		int min = arr[0]; // 인덱스로 가져오기 

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max)max = arr[i];
			if (arr[i] < min)min = arr[i];
		}
		System.out.println(min + " " + max);

	}

}
