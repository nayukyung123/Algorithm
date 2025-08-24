import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
        
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
			sb.append(i).append("\n");
		}
        System.out.println(sb.toString());
    }
}