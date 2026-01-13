import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] minusPart = input.split("-");

		int result = 0;

		for (int i = 0; i < minusPart.length; i++) {
			int tempSum = 0;
			String[] plusPart = minusPart[i].split("\\+"); // 50, 40

			for (String num : plusPart) {
				tempSum += Integer.parseInt(num); // 50 + 40 -> 90
			}

			if (i == 0) { // 첫번째는 더하고
				result = tempSum;
			} else {// 두번째는 뺌
				result -= tempSum;
			}

		}
		System.out.println(result);

	}
}
