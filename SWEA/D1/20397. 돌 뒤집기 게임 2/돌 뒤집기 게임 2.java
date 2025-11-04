
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); 

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt(); 

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt(); 
            }

            
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt() - 1; 
                int b = sc.nextInt();

               
                for (int k = 1; k <= b; k++) {
                    int left = a - k;  
                    int right = a + k; 

                   
                    if (left >= 0 && left < n && right >= 0 && right < n) {
                        if (arr[left] == arr[right]) {  
                            arr[left] = 1 - arr[left]; 
                            arr[right] = 1 - arr[right];
                        }
                    }
                }
            }

           
            System.out.print("#" + tc + " ");
            for (int j = 0; j < n; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println(); 
        }

        sc.close(); 
    }
}
