import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력받기
        int N = sc.nextInt(); // 친구 수
        int M = sc.nextInt(); // 종료 조건 (한 사람이 M번 공을 받으면 끝)
        int L = sc.nextInt(); // 던질 거리

        // 2. 원형 배열로 공 던지기 구현
        int[] count = new int[N]; // 각 사람이 공 받은 횟수
        int idx = 0;              // 현재 공을 가진 사람 (0번 → 1번 친구)
        count[idx] = 1;           // 첫 번째 사람 공 받음
        int thr = 0;              // 던진 횟수

        while (count[idx] < M) { // 누군가 M번 받으면 종료
            if (count[idx] % 2 == 1) { // 받은 횟수가 홀수 → 시계 방향
                idx = (idx + L) % N;
            } else { // 받은 횟수가 짝수 → 반시계 방향
                idx = (idx - L + N) % N; // 음수 방지 위해 +N
            }

            count[idx]++; // 새로 공 받은 사람 카운트 증가
            thr++;        // 던진 횟수 증가
        }

        // 결과 출력
        System.out.println(thr);
    }
}
