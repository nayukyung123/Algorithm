import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력받기
        int n = sc.nextInt();          // 스위치 개수
        int[] switchLen = new int[n];  // 스위치 상태 저장
        for (int i = 0; i < n; i++) {
            switchLen[i] = sc.nextInt();
        }

        int s = sc.nextInt();          // 학생 수

        // 2. 학생 처리
        for (int i = 0; i < s; i++) {
            int gender = sc.nextInt(); // 성별 (1: 남, 2: 여)
            int sn = sc.nextInt();     // 받은 수

            if (gender == 1) { // 남학생
                for (int j = 0; j < n; j++) {
                    if ((j + 1) % sn == 0) { // 배수 위치면 토글
                        switchLen[j] = (switchLen[j] == 0) ? 1 : 0;
                    }
                }
            } 
            else if (gender == 2) { // 여학생
                int idx = sn - 1; // 배열은 0부터 시작하니까 -1
                int left = idx, right = idx;

                // 좌우 대칭 확인
                while (left - 1 >= 0 && right + 1 < n
                        && switchLen[left - 1] == switchLen[right + 1]) {
                    left--;
                    right++;
                }

                // [left, right] 구간 토글
                for (int j = left; j <= right; j++) {
                    switchLen[j] = (switchLen[j] == 0) ? 1 : 0;
                }
            }
        }

        // 4. 출력 (20개씩 끊어서 출력)
        for (int i = 0; i < n; i++) {
            System.out.print(switchLen[i] + " ");
            if ((i + 1) % 20 == 0) System.out.println();
        }
    }
}
