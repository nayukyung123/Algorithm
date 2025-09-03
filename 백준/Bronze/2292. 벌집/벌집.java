import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 1; // 층
		int lastNum = 1; // 마지막 방 번호
		
		while (lastNum < N) {
			lastNum += 6*count; // 마지막 방 번호를 구하는중..
			count++;//마지막 번호를 구했으면 층수 옹ㄹ리기......
		}
		System.out.println(count);

	}
}

