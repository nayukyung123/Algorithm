import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	static int[][] points = new int[4][2];
    static int[] order = {1, 2, 3};
    static double min = Double.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        permute(0);
        System.out.println((int) min);
    }

    static void permute(int depth) {
        if (depth == 3) {
            double dist = 0.0;
            int from = 0;
            for (int i = 0; i < 3; i++) {
                int to = order[i];
                dist += distance(points[from], points[to]);
                from = to;
            }
            min = Math.min(min, dist);
            return;
        }

        for (int i = depth; i < 3; i++) {
            swap(depth, i);
            permute(depth + 1);
            swap(depth, i);
        }
    }

    static void swap(int i, int j) {
        int temp = order[i];
        order[i] = order[j];
        order[j] = temp;
    }

    static double distance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return Math.sqrt(dx * dx + dy * dy);
    }
}