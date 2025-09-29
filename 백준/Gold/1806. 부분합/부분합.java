import java.io.*;
import java.util.*;
// 모든 구간의 합을 일일이 계산하면 시간초과
// 왼쪽, 오른쪽 두개의 포인터로 관리 
public class Main {

	static int n, s, minLen, sum, start;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());// 수열길이 
		s = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		
		start = 0; // 왼쪽포인터 
		sum = 0; // 현재 부분합 
		minLen = Integer.MAX_VALUE;//최소길이(초기값크게설정)

		//오른쪽 포인터를 한칸식이동 
		for (int end = 0; end < n; end++) { 
			sum += arr[end];// 새로운 원소 포함해서 부분합 업데이트 

			//부분합이 목표 s 이상이면 -> 왼쪽 포인터를 당겨서 최소 길이 줄여보기 
			while (sum >= s) {
				minLen = Math.min(minLen, end - start + 1); // 현재 구간길이와 비교 후 최소 길이 후보 갱신 
				sum -= arr[start]; // 왼쪽 원소빼고 길이 줄임 
				start++;
			}

		}

		//ans가 갱신이 안 됐다면 만족하는 부분 배열이 없는 것 -> 0 출력 
		if (minLen == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(minLen);
		}

	}
}