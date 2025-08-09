import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();                  
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();               
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt(); 

            int maxDrop = 0;

            for (int i = 0; i < N; i++) {
                int drop = 0;
                for (int j = i + 1; j < N; j++) {
                    
                    if (arr[i] > arr[j]) drop++;
                }
                if (drop > maxDrop) maxDrop = drop;
            }

            System.out.println("#" + tc + " " + maxDrop);
        }
    }
}