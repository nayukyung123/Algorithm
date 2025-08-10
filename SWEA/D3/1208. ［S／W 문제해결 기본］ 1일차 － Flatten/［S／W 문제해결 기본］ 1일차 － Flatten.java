import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int dump = sc.nextInt();
            int[] box = new int[100];
            for (int i = 0; i < 100; i++) box[i] = sc.nextInt();

            while (dump-- > 0) {
                int maxIdx = 0, minIdx = 0;
                for (int i = 1; i < 100; i++) {
                    if (box[i] > box[maxIdx]) maxIdx = i;
                    if (box[i] < box[minIdx]) minIdx = i;
                }
                if (box[maxIdx] - box[minIdx] <= 1) break;  // 평탄화
                box[maxIdx]--; 
                box[minIdx]++;
            }

            int max = Arrays.stream(box).max().getAsInt();
            int min = Arrays.stream(box).min().getAsInt();

            System.out.printf("#%d %d%n", t, max - min);
        }
    }
}