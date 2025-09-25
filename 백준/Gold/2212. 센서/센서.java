import java.io.*;
import java.util.*;

//어떻게 K로 쪼갠 배열의 합이 최소값이 될 수 있을까

public class Main {

	static int[] arr;
	static int N;
	static int K;
	static int sum;
	static Integer[] diff; // 내림차순 정렬을 위해 Integer[]사용, 센서 거리 값들 들어가있음

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		arr = new int[N]; // 1 6 9 3 6 7
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		Arrays.sort(arr);// 1 3 6 6 7 9

		diff = new Integer[N - 1]; // 
		for (int i = 0; i < N - 1; i++) {
			diff[i] = arr[i + 1] - arr[i]; // [2, 3, 0, 1, 2]
		}

		Arrays.sort(diff, Collections.reverseOrder()); // [0, 1, 2, 2, 3]

		sum = 0;
		for (int i = K - 1; i < diff.length; i++) { //K - 1 : 가장 큰 간격 버리기 위해 
			sum+=diff[i];							//  9 -> 버림 :  [3, 2, 2, 1, 0]
		}
		
		System.out.println(sum);
	}
}
